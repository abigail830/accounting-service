package com.github.abigail830.ecommerce.reporting.application.service;

import com.github.abigail830.ecommerce.reporting.application.dto.MonthlyReportRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportingApplService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public MonthlyReportRespDTO getMonthlyReport() {
        //TODO: join table and query DB
        return null;
    }


}
