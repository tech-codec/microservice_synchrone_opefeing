package org.id.billingservice.web;

import org.id.billingservice.dto.RequestBilling;
import org.id.billingservice.dto.ResponseBilling;
import org.id.billingservice.services.BillingServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class BillingController {
    private BillingServiceI billingServiceI;

    public BillingController(BillingServiceI billingServiceI) {
        this.billingServiceI = billingServiceI;
    }

    @GetMapping("/AllBilling")
    List<ResponseBilling> allBilling(){
        return billingServiceI.allBilling();
    }

    @GetMapping("/ShowBilling/{billingId}")
    ResponseBilling showBilling(@PathVariable Long billingId){
        return billingServiceI.showBilling(billingId);
    }

    @PostMapping("/CreateBilling")
    ResponseBilling createBilling(@RequestBody RequestBilling requestBilling){
        return billingServiceI.createBilling(requestBilling);
    }

    @GetMapping("/DeleteBilling/{billingId}")
    void deleteBilling(@PathVariable Long billingId){
        billingServiceI.deleteBilling(billingId);
    }
}
