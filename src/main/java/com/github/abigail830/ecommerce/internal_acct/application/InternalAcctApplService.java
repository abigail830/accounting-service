package com.github.abigail830.ecommerce.internal_acct.application;

import com.github.abigail830.ecommerce.internal_acct.application.dto.CreateInternalAcctRequest;
import com.github.abigail830.ecommerce.internal_acct.domain.InternalAcctService;
import com.github.abigail830.ecommerce.internal_acct.domain.model.InternalAcct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InternalAcctApplService {

    @Autowired
    InternalAcctService internalAcctService;

    @Transactional
    public String createInternalAcct(CreateInternalAcctRequest createInternalAcctRequest) {
        final InternalAcct internalAcct = internalAcctService.createInternalAcct(
                createInternalAcctRequest.getCcy(),
                createInternalAcctRequest.getBalanceAmt());

        log.info("Created internal account [{}].", internalAcct.getId());
        return internalAcct.getId();
    }

    @Transactional
    public void freezeInternalAcct(String id) {
        final InternalAcct freeze = internalAcctService.freeze(id);
        log.info("Internal Account[{}] freeze.", id);
    }

    @Transactional
    public void unfreezeInternalAcct(String id) {
        final InternalAcct freeze = internalAcctService.unfreeze(id);
        log.info("Internal Account[{}] freeze.", id);
    }
}
