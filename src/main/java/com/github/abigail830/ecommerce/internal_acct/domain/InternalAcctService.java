package com.github.abigail830.ecommerce.internal_acct.domain;

import com.github.abigail830.ecommerce.internal_acct.domain.exception.InternalAcctNotFoundException;
import com.github.abigail830.ecommerce.internal_acct.domain.model.InternalAcct;
import com.github.abigail830.ecommerce.internal_acct.domain.model.InternalAcctFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Component
@Slf4j
public class InternalAcctService {

    @Autowired
    InternalAcctRepository internalAcctRepository;

    @Autowired
    InternalAcctFactory internalAcctFactory;

    public InternalAcct createInternalAcct(@Valid @NotEmpty(message = "币种不能为空") String ccy,
                                           @NotNull(message = "余额不能为空") BigDecimal balance) {
        InternalAcct internalAcct = internalAcctFactory.create(ccy, balance);
        internalAcctRepository.save(internalAcct);
        return internalAcct;
    }

    public InternalAcct freeze(String id) {
        final InternalAcct internalAcct = internalAcctRepository.byId(id)
                .orElseThrow(() -> new InternalAcctNotFoundException(id));
        internalAcct.freeze(id);
        internalAcctRepository.save(internalAcct);
        return internalAcct;
    }

    public InternalAcct unfreeze(String id) {
        final InternalAcct internalAcct = internalAcctRepository.byId(id)
                .orElseThrow(() -> new InternalAcctNotFoundException(id));
        internalAcct.unfreeze(id);
        internalAcctRepository.save(internalAcct);
        return internalAcct;
    }
}
