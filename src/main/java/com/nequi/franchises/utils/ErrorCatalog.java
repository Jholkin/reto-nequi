package com.nequi.franchises.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    FRANCHISE_NOT_FOUND("ERR_FRANCHISE_001","FRANCHISE_NOT_FOUND"),
    INVALID_FRANCHISE("ERR_FRANCHISE_002","INVALID_FRANCHISE"),
    GENERIC_ERROR("ERR_GENERIC_001","GENERIC_ERROR");

    private final String code;
    private final String message;

    ErrorCatalog(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
