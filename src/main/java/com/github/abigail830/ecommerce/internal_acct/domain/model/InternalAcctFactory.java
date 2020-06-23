package com.github.abigail830.ecommerce.internal_acct.domain.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class InternalAcctFactory {

    public InternalAcct create(String ccy, BigDecimal balance) {
        String internalAcctId = generate();
        return InternalAcct.create(internalAcctId, ccy, balance);
    }

    public String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
