package com.heymart.authenticate.enums;

import lombok.Getter;

@Getter
public enum ApplicationUserPermission {
    AUTH_CREATE_MANAGER("auth:create_manager"),

    // Coupon
    COUPON_READ("coupon:read"),
    COUPON_CREATE("coupon:create"),
    COUPON_UPDATE("coupon:update"),
    COUPON_DELETE("coupon:delete"),

    // Product
    PRODUCT_READ("product:read"),
    PRODUCT_CREATE("product:create"),
    PRODUCT_EDIT("product:edit"),
    PRODUCT_DELETE("product:delete"),
    // Category
    CATEGORY_CREATE("categories:create"),
    CATEGORY_READ("categories:read"),
    CATEGORY_DELETE("categories:delete"),

    // User Balance
    USER_BALANCE_CREATE("balance:ub_create"),
    SUPERMARKET_BALANCE_CRATE("balance:sb_create"),
    USER_BALANCE_READ("balance:ub_read"),
    SUPERMARKET_BALANCE_READ("balance:sb_read"),
    USER_BALANCE_UPDATE("balance:ub_update"),
    SUPERMARKET_BALANCE_UPDATE("balance:sb_update"),
    TRANSACTION_READ("transaction:read");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

}
