package com.github.abigail830.ecommerce.internal_acct.domain.repo;

import com.github.abigail830.ecommerce.internal_acct.domain.entity.InternalAcctAggRoot;

import java.util.Optional;

public interface InternalAcctRepo {

    void save(InternalAcctAggRoot internalAcctAggRoot);

    Optional<InternalAcctAggRoot> byId(String id);


}

