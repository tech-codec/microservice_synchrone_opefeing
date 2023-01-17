package org.id.productservice.services;

import org.id.productservice.dao.ProductRepository;
import org.id.productservice.dto.RequestProduct;
import org.id.productservice.dto.ResponsProduct;
import org.id.productservice.entities.Product;
import org.id.productservice.mappers.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductServiceI {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public ResponsProduct createProduct(RequestProduct requestProduct) {
        Product product = productMapper.requestProductToProduct(requestProduct);

        Product productSave = productRepository.save(product);

        ResponsProduct responsProduct = productMapper.productToResponsProduct(product);

        return responsProduct;
    }

    @Override
    public ResponsProduct showProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return productMapper.productToResponsProduct(product);
    }

    @Override
    public ResponsProduct updateProduct(RequestProduct requestProduct, Long productId) {
        Product product = productMapper.requestProductToProduct(requestProduct);
        Product product1 = productRepository.findById(productId).orElse(null);
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        Product productUpdate = productRepository.save(product1);
        return productMapper.productToResponsProduct(productUpdate);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.delete(product);
    }

    @Override
    public List<ResponsProduct> allProduct() {
        List<Product> products = productRepository.findAll();
        List<ResponsProduct> responsProductlist = products.stream()
                .map(product -> productMapper.productToResponsProduct(product))
                .collect(Collectors.toList());
        return responsProductlist;
    }
}
