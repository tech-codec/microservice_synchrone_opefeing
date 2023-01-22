package org.id.billingservice.mappers;

import org.id.billingservice.dto.RequestProductItem;
import org.id.billingservice.dto.ResponseProductItem;
import org.id.billingservice.entities.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    ProductItem requestProductItemToProductItem(RequestProductItem requestProductItem);
    ResponseProductItem productItemToResponseProductItem(ProductItem productItem);
}
