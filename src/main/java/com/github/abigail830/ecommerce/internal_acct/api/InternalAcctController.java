package com.github.abigail830.ecommerce.internal_acct.api;

import com.github.abigail830.ecommerce.internal_acct.application.InternalAcctApplService;
import com.github.abigail830.ecommerce.internal_acct.application.dto.CreateInternalAcctRequest;
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
    InternalAcctApplService internalAcctApplService;


    @PostMapping
    @ResponseStatus(CREATED)
    public Map<String, String> createInternalAcct(
            @RequestBody @Valid CreateInternalAcctRequest createInternalAcctRequest) {
        return of("id", internalAcctApplService.createInternalAcct(createInternalAcctRequest));
    }

    @PostMapping("/{id}/freeze")
    public void freezeInternalAcct(
            @PathVariable String id) {
        internalAcctApplService.freezeInternalAcct(id);
    }

    @PostMapping("/{id}/unfreeze")
    public void unfreezeInternalAcct(
            @PathVariable String id) {
        internalAcctApplService.unfreezeInternalAcct(id);
    }


}
