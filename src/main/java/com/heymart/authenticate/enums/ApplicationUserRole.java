package com.heymart.authenticate.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.heymart.authenticate.enums.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    ADMIN(Sets.newHashSet(AUTH_CREATE_MANAGER, COUPON_READ, PRODUCT_READ)),
    CUSTOMER(Sets.newHashSet(COUPON_READ, USER_BALANCE_CREATE, USER_BALANCE_READ, USER_BALANCE_UPDATE,
            BOTH_BALANCE_UPDATE, TRANSACTION_READ, PRODUCT_READ)),
    MANAGER(Sets.newHashSet(
            // Coupon
            COUPON_CREATE, COUPON_READ, COUPON_DELETE, COUPON_UPDATE,

            // Supermarket Balance
            SUPERMARKET_BALANCE_CRATE, SUPERMARKET_BALANCE_READ, SUPERMARKET_BALANCE_UPDATE, BOTH_BALANCE_UPDATE,
            TRANSACTION_READ,

            // Product & Category
            PRODUCT_CREATE, PRODUCT_READ, PRODUCT_EDIT, PRODUCT_DELETE,
            CATEGORY_CREATE, CATEGORY_DELETE, CATEGORY_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
