package org.id.billingservice.mappers;

import org.id.billingservice.dto.RequestProductItem;
import org.id.billingservice.dto.ResponseProductItem;
import org.id.billingservice.entities.ProductItem;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductItem requestProductItemToProductItem(RequestProductItem requestProductItem);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ResponseProductItem productItemToResponseProductItem(ProductItem productItem);
}
