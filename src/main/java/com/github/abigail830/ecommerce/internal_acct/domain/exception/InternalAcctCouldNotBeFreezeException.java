package com.github.abigail830.ecommerce.internal_acct.domain.exception;

import com.github.abigail830.ecommerce.exception.BizException;

import static com.google.common.collect.ImmutableMap.of;

public class InternalAcctCouldNotBeFreezeException extends BizException {
    public InternalAcctCouldNotBeFreezeException(String internalAcctId) {
        super(InternalAcctErrorCode.INTERNAL_ACCT_COULD_NOT_BE_FREEZEN, of("InternalAcctId", internalAcctId));
    }
}
