package com.github.abigail830.ecommerce.internal_acct.domain;

import com.github.abigail830.ecommerce.internal_acct.domain.model.InternalAcct;

import java.util.Optional;

public interface InternalAcctRepository {

    void save(InternalAcct internalAcct);

    Optional<InternalAcct> byId(String id);


}

