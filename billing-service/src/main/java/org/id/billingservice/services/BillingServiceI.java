package org.id.billingservice.services;

import org.id.billingservice.dto.RequestBilling;
import org.id.billingservice.dto.ResponseBilling;

import java.util.List;

public interface BillingServiceI {
    List<ResponseBilling> allBilling();
    ResponseBilling showBilling(Long billingId);
    ResponseBilling createBilling(RequestBilling requestBilling);
    void deleteBilling(Long billingId);
}
