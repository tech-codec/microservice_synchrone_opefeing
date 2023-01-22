package org.id.billingservice.services;

import org.id.billingservice.dto.RequestProductItem;
import org.id.billingservice.dto.ResponseProductItem;

import java.util.List;

public interface ProductItemServiceI {
    List<ResponseProductItem> allProductItem();
    ResponseProductItem showProductItem(Long productItemId);
}
