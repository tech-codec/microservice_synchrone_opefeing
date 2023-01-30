package org.id.productservice.mappers;

import org.id.productservice.dto.RequestProduct;
import org.id.productservice.dto.ResponsProduct;
import org.id.productservice.entities.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product requestProductToProduct(RequestProduct requestProduct);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ResponsProduct productToResponsProduct(Product product);
}
