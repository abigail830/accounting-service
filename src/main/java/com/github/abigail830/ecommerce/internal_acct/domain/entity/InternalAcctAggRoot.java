package com.github.abigail830.ecommerce.internal_acct.domain.entity;


import com.github.abigail830.ecommerce.internal_acct.domain.exception.InternalAcctCouldNotBeFreezeException;
import com.github.abigail830.ecommerce.internal_acct.domain.exception.InternalAcctCouldNotBeUnFreezeException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static java.time.Instant.now;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InternalAcctAggRoot {

    private String id;
    private String ccy;
    private BigDecimal balance;
    private InternalAcctStatus status;
    private Instant lastUpdateAt;

    public InternalAcctAggRoot(String id, String ccy, BigDecimal balance,
                               InternalAcctStatus status, Instant lastUpdateAt) {
        this.id = id;
        this.ccy = ccy;
        this.balance = balance;
        this.status = status;
        this.lastUpdateAt = lastUpdateAt;
    }

    public static InternalAcctAggRoot create(String id, String ccy, BigDecimal balance) {
        return new InternalAcctAggRoot(id,
                ccy, balance, InternalAcctStatus.CREATED, now());
    }

    public static InternalAcctAggRoot restore(String id, String ccy, BigDecimal balance, String status, Timestamp lastUpdateAt) {
        return new InternalAcctAggRoot(id, ccy, balance, InternalAcctStatus.valueOf(status), lastUpdateAt.toInstant());
    }


    public void freeze(String id) {
        if (this.status != InternalAcctStatus.CREATED && this.status != InternalAcctStatus.ENABLE) {
            throw new InternalAcctCouldNotBeFreezeException(id);
        }
        this.status = InternalAcctStatus.FREEZEN;
    }

    public void unfreeze(String id) {
        if(this.status != InternalAcctStatus.FREEZEN){
            throw new InternalAcctCouldNotBeUnFreezeException(id);
        }
        this.status = InternalAcctStatus.UNFREEZEN;
    }
}
