package com.github.abigail830.ecommerce.internal_acct.domain.exception;

import com.github.abigail830.ecommerce.exception.BizException;

import static com.google.common.collect.ImmutableMap.of;

public class InternalAcctNotFoundException extends BizException {
    public InternalAcctNotFoundException(String internalAcctId) {
        super(InternalAcctErrorCode.INTERNAL_ACCT_NOT_FOUND, of("InternalAcctId", internalAcctId));
    }
}
