package com.github.abigail830.ecommerce.internal_acct.infra.persistent;

import com.github.abigail830.ecommerce.internal_acct.domain.entity.InternalAcctAggRoot;
import com.github.abigail830.ecommerce.internal_acct.domain.repo.InternalAcctRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InternalAcctRepoImpl implements InternalAcctRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(InternalAcctAggRoot internalAcctAggRoot) {
        final String insertSql = "INSERT INTO INTERNAL_ACCT_TBL (ID, CCY, BALANCE, STATUS, LAST_UPDATE_AT) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE CCY=?, BALANCE=?, STATUS=?, LAST_UPDATE_AT=?";
        jdbcTemplate.update(insertSql, internalAcctAggRoot.getId(),
                internalAcctAggRoot.getCcy(), internalAcctAggRoot.getBalance(),
                internalAcctAggRoot.getStatus().name(), internalAcctAggRoot.getLastUpdateAt(),
                internalAcctAggRoot.getCcy(), internalAcctAggRoot.getBalance(),
                internalAcctAggRoot.getStatus().name(), internalAcctAggRoot.getLastUpdateAt());

        log.info("Internal account {} saved", internalAcctAggRoot);
    }

    @Override
    public Optional<InternalAcctAggRoot> byId(String id) {
        final String selectItemByIdSql = "SELECT * FROM INTERNAL_ACCT_TBL WHERE ORDER_ID = ?";
        final List<InternalAcctAggRoot> internalAcctAggRoots = jdbcTemplate.query(selectItemByIdSql, ((resultSet, i) -> InternalAcctAggRoot.restore(
                resultSet.getString("ID"),
                resultSet.getString("CCY"),
                resultSet.getBigDecimal("BALANCE"),
                resultSet.getString("STATUS"),
                resultSet.getTimestamp("LAST_UPDATE_AT"))), id);
        return internalAcctAggRoots.stream().findFirst();
    }


}
