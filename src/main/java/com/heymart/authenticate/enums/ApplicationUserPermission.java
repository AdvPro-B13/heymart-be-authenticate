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
    PRODUCT_DELETE("product:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

}
