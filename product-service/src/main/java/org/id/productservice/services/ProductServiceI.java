package org.id.productservice.services;

import org.id.productservice.dto.RequestProduct;
import org.id.productservice.dto.ResponsProduct;

import java.util.List;

public interface ProductServiceI {
    ResponsProduct createProduct(RequestProduct requestProduct);
    ResponsProduct showProduct(Long productId);
    ResponsProduct updateProduct(RequestProduct requestProduct, Long productId);
    void deleteProduct(Long productId);
    List<ResponsProduct> allProduct();
}
