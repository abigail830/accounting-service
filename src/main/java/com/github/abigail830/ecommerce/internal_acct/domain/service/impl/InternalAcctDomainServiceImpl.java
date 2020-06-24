package com.github.abigail830.ecommerce.internal_acct.domain.service.impl;

import com.github.abigail830.ecommerce.exception.InternalAcctException;
import com.github.abigail830.ecommerce.internal_acct.domain.common.IdGenerator;
import com.github.abigail830.ecommerce.internal_acct.domain.entity.InternalAcctAggRoot;
import com.github.abigail830.ecommerce.internal_acct.domain.repo.InternalAcctRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Component
@Slf4j
public class InternalAcctDomainServiceImpl {

    @Autowired
    InternalAcctRepo internalAcctRepo;

    public InternalAcctAggRoot createInternalAcct(@Valid @NotEmpty(message = "币种不能为空") String ccy,
                                                  @NotNull(message = "余额不能为空") BigDecimal balance) {
        InternalAcctAggRoot internalAcctAggRoot = InternalAcctAggRoot.create(IdGenerator.generate(), ccy, balance);
        internalAcctRepo.save(internalAcctAggRoot);
        return internalAcctAggRoot;
    }

    public InternalAcctAggRoot freeze(String id) {
        final InternalAcctAggRoot internalAcctAggRoot = internalAcctRepo.byId(id)
                .orElseThrow(() -> new InternalAcctException(id));
        internalAcctAggRoot.freeze(id);
        internalAcctRepo.save(internalAcctAggRoot);
        return internalAcctAggRoot;
    }

    public InternalAcctAggRoot unfreeze(String id) {
        final InternalAcctAggRoot internalAcctAggRoot = internalAcctRepo.byId(id)
                .orElseThrow(() -> new InternalAcctException(id));
        internalAcctAggRoot.unfreeze(id);
        internalAcctRepo.save(internalAcctAggRoot);
        return internalAcctAggRoot;
    }

    public void fetch(String id, String ccy) {
        final InternalAcctAggRoot internalAcctAggRoot = internalAcctRepo.byId(id)
                .orElseThrow(() -> new InternalAcctException(id));

    }
}
