package com.github.abigail830.ecommerce.exception;

import static com.google.common.collect.ImmutableMap.of;

public class InternalAcctException extends BizException {
    public InternalAcctException(String internalAcctId) {
        super(InternalAcctErrorCode.INTERNAL_ACCT_NOT_FOUND, of("InternalAcctId", internalAcctId));
    }
}
