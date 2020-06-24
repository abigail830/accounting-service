package com.github.abigail830.ecommerce.internal_acct.application.dto;

import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreateInternalAcctReqDTO {

    @Valid
    @NotEmpty(message = "币种不能为空")
    private String ccy;

    @NotNull(message = "余额不能为空")
    private BigDecimal balanceAmt;


}
