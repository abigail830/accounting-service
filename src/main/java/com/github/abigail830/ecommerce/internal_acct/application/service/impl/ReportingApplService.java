package com.github.abigail830.ecommerce.internal_acct.application.service.impl;

import com.github.abigail830.ecommerce.internal_acct.domain.repo.InternalAcctRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReportingApplService {

    @Autowired
    InternalAcctRepo internalAcctRepo;
}
