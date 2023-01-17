package org.id.productservice.mappers;

import org.id.productservice.dto.RequestProduct;
import org.id.productservice.dto.ResponsProduct;
import org.id.productservice.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product requestProductToProduct(RequestProduct requestProduct);
    ResponsProduct productToResponsProduct(Product product);
}
