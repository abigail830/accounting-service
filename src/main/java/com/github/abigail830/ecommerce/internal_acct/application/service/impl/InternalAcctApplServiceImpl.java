package com.github.abigail830.ecommerce.internal_acct.application.service.impl;

import com.github.abigail830.ecommerce.internal_acct.application.dto.CreateInternalAcctReqDTO;
import com.github.abigail830.ecommerce.internal_acct.application.dto.FetchInternalAcctReqDTO;
import com.github.abigail830.ecommerce.internal_acct.domain.entity.InternalAcctAggRoot;
import com.github.abigail830.ecommerce.internal_acct.domain.service.impl.InternalAcctDomainServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InternalAcctApplServiceImpl {

    @Autowired
    InternalAcctDomainServiceImpl internalAcctDomainServiceImpl;

    @Transactional
    public String createInternalAcct(CreateInternalAcctReqDTO createInternalAcctReqDTO) {
        final InternalAcctAggRoot internalAcctAggRoot = internalAcctDomainServiceImpl.createInternalAcct(
                createInternalAcctReqDTO.getCcy(),
                createInternalAcctReqDTO.getBalanceAmt());

        log.info("Created internal account [{}].", internalAcctAggRoot.getId());
        return internalAcctAggRoot.getId();
    }

    @Transactional
    public void freezeInternalAcct(String id) {
        final InternalAcctAggRoot freeze = internalAcctDomainServiceImpl.freeze(id);
        log.info("Internal Account[{}] freeze.", id);
    }

    @Transactional
    public void unfreezeInternalAcct(String id) {
        final InternalAcctAggRoot freeze = internalAcctDomainServiceImpl.unfreeze(id);
        log.info("Internal Account[{}] freeze.", id);
    }

    @Transactional
    public void fetchInternalAcct(FetchInternalAcctReqDTO fetchInternalAcctReqDTO) {
        internalAcctDomainServiceImpl.fetch(fetchInternalAcctReqDTO.getId(),
                fetchInternalAcctReqDTO.getCcy());
    }
}
