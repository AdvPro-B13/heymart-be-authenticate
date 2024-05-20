package com.heymart.authenticate.service;

import com.heymart.authenticate.model.Customer;
import com.heymart.authenticate.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCoupon() {
        List<Customer> customers = new ArrayList<>();
        List<String> couponIds = new ArrayList<>();
        Customer customer1 = new Customer(1L, "John", "Doe", "pass123", "johndoe", "user", true, couponIds);
        customers.add(customer1);
        Customer customer2 = new Customer(1L, "John", "Doe", "pass123", "johndoe", "user", true, couponIds);
        customers.add(customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        customerService.addCoupon("COUPON1");

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository, times(2)).save(customerCaptor.capture());

        List<Customer> savedCustomers = customerCaptor.getAllValues();
        assertThat(savedCustomers).hasSize(2);
        assertThat(savedCustomers.get(0).getCouponIds()).contains("COUPON1");
        assertThat(savedCustomers.get(1).getCouponIds()).contains("COUPON1");
    }

    @Test
    public void testRemoveCouponFromAll() {
        List<Customer> customers = new ArrayList<>();
        List<String> couponIds = new ArrayList<>();
        couponIds.add("COUPON1");
        couponIds.add("COUPON2");
        List<String> couponIds2 = new ArrayList<>(couponIds);
        Customer customer1 = new Customer(1L, "John", "Doe", "pass123", "johndoe", "user", true, couponIds);
        customers.add(customer1);
        Customer customer2 = new Customer(1L, "John", "Doe", "pass123", "johndoe", "user", true, couponIds2);
        customers.add(customer2);


        when(customerRepository.findAll()).thenReturn(customers);

        customerService.removeCouponFromAll("COUPON1");

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository, times(2)).save(customerCaptor.capture());

        List<Customer> savedCustomers = customerCaptor.getAllValues();
        assertThat(savedCustomers).hasSize(2);
        assertThat(savedCustomers.get(0).getCouponIds()).doesNotContain("COUPON1");
        assertThat(savedCustomers.get(1).getCouponIds()).doesNotContain("COUPON1").contains("COUPON2");
    }

    @Test
    public void testRemoveCoupon_UserNotFound() {
        when(customerRepository.findByUsername(any(String.class))).thenReturn(Optional.empty());

        assertThatThrownBy(() -> customerService.removeCoupon("COUPON1", "nonexistentUser"))
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessage("User not found");
    }

    @Test
    public void testRemoveCoupon() {
        List<String> couponIds = new ArrayList<>();
        couponIds.add("COUPON1");
        couponIds.add("COUPON2");
        Customer customer = new Customer(1L, "John", "Doe", "pass123", "johndoe", "user", true, couponIds);
        when(customerRepository.findByUsername("existingUser")).thenReturn(Optional.of(customer));

        customerService.removeCoupon("COUPON1", "existingUser");

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository, times(1)).save(customerCaptor.capture());

        Customer savedCustomer = customerCaptor.getValue();
        assertThat(savedCustomer.getCouponIds()).doesNotContain("COUPON1").contains("COUPON2");
    }
}
