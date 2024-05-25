package com.heymart.authenticate.enums;

import lombok.Getter;

@Getter
public enum ApplicationUserPermission {
    AUTH_CREATE_MANAGER("auth:create_manager"),
    COUPON_READ("coupon:read"),
    COUPON_CREATE("coupon:create"),
    COUPON_UPDATE("coupon:update"),
    COUPON_DELETE("coupon:delete"),
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
