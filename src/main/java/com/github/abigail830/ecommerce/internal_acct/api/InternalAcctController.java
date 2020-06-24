package com.github.abigail830.ecommerce.internal_acct.api;

import com.github.abigail830.ecommerce.internal_acct.application.dto.CreateInternalAcctReqDTO;
import com.github.abigail830.ecommerce.internal_acct.application.dto.FetchInternalAcctReqDTO;
import com.github.abigail830.ecommerce.internal_acct.application.service.impl.InternalAcctApplServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/internal-accounts")
public class InternalAcctController {

    @Autowired
    InternalAcctApplServiceImpl internalAcctApplServiceImpl;


    @PostMapping
    @ResponseStatus(CREATED)
    public Map<String, String> createInternalAcct(
            @RequestBody @Valid CreateInternalAcctReqDTO createInternalAcctReqDTO) {
        return of("id", internalAcctApplServiceImpl.createInternalAcct(createInternalAcctReqDTO));
    }

    @PostMapping("/fetch")
    public void fetchInternalAcct(@RequestBody FetchInternalAcctReqDTO fetchInternalAcctReqDTO) {
        internalAcctApplServiceImpl.fetchInternalAcct(fetchInternalAcctReqDTO);
    }

    @PostMapping("/{id}/freeze")
    public void freezeInternalAcct(
            @PathVariable String id) {
        internalAcctApplServiceImpl.freezeInternalAcct(id);
    }

    @PostMapping("/{id}/unfreeze")
    public void unfreezeInternalAcct(
            @PathVariable String id) {
        internalAcctApplServiceImpl.unfreezeInternalAcct(id);
    }


}
