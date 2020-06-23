package com.github.abigail830.ecommerce.internal_acct.infrastructure.persistent;

import com.github.abigail830.ecommerce.internal_acct.domain.InternalAcctRepository;
import com.github.abigail830.ecommerce.internal_acct.domain.model.InternalAcct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InternalAcctRepositoryImpl implements InternalAcctRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(InternalAcct internalAcct) {
        final String insertSql = "INSERT INTO INTERNAL_ACCT_TBL (ID, CCY, BALANCE, STATUS, LAST_UPDATE_AT) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE CCY=?, BALANCE=?, STATUS=?, LAST_UPDATE_AT=?";
        jdbcTemplate.update(insertSql, internalAcct.getId(),
                internalAcct.getCcy(), internalAcct.getBalance(),
                internalAcct.getStatus().name(), internalAcct.getLastUpdateAt(),
                internalAcct.getCcy(), internalAcct.getBalance(),
                internalAcct.getStatus().name(), internalAcct.getLastUpdateAt());

        log.info("Internal account {} saved", internalAcct);
    }

    @Override
    public Optional<InternalAcct> byId(String id) {
        final String selectItemByIdSql = "SELECT * FROM ORDER_ITEM_TBL WHERE ORDER_ID = ?";
        final List<InternalAcct> internalAccts = jdbcTemplate.query(selectItemByIdSql, ((resultSet, i) -> InternalAcct.restore(
                resultSet.getString("ID"),
                resultSet.getString("CCY"),
                resultSet.getBigDecimal("BALANCE"),
                resultSet.getString("STATUS"),
                resultSet.getTimestamp("LAST_UPDATE_AT"))), id);
        return internalAccts.stream().findFirst();
    }



}
