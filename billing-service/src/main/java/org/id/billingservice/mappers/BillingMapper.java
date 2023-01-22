package org.id.billingservice.mappers;

import org.id.billingservice.dto.RequestBilling;
import org.id.billingservice.dto.ResponseBilling;
import org.id.billingservice.entities.Billing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillingMapper {
    ResponseBilling billingToResponseBilling(Billing billing);
}
