package org.id.billingservice.mappers;

import org.id.billingservice.dto.RequestBilling;
import org.id.billingservice.dto.ResponseBilling;
import org.id.billingservice.entities.Billing;
import org.mapstruct.Mapper;

@Mapper
public interface BillingMapper {
    Billing requestBilligToBilling(RequestBilling requestBilling);
    ResponseBilling billingToResponseBilling(Billing billing);
}
