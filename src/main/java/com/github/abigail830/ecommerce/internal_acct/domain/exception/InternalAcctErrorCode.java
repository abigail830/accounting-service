package com.github.abigail830.ecommerce.internal_acct.domain.exception;


import com.github.abigail830.ecommerce.exception.ErrorCode;

public enum InternalAcctErrorCode implements ErrorCode {

    INTERNAL_ACCT_NOT_FOUND("没有找到内部户"),
    INTERNAL_ACCT_COULD_NOT_BE_FREEZEN("内部户无法冻结"),
    INTERNAL_ACCT_COULD_NOT_BE_UNFREEZEN("内部户无法解冻");

    private String message;

    InternalAcctErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
