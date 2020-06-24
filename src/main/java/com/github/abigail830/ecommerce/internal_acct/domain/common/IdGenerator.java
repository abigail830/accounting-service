package com.github.abigail830.ecommerce.internal_acct.domain.common;

import java.util.UUID;

public class IdGenerator {

    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
