package com.heymart.authenticate.service;

import com.heymart.authenticate.model.Customer;
import com.heymart.authenticate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public void addCoupon(String couponId) {
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            customer.getCouponIds().add(couponId);
            customerRepository.save(customer);
        }
    }
    public void removeCouponFromAll(String couponId) {
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            if (customer.getCouponIds().remove(couponId)) {
                customerRepository.save(customer);
            }
        }
    }
    public void removeCoupon(String couponId, String username) {
        Customer customer = customerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (customer.getCouponIds().remove(couponId)) {
            customerRepository.save(customer);
        }
    }
}
