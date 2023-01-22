package org.id.billingservice.services;

import org.id.billingservice.customerrest.ProductRestClient;
import org.id.billingservice.dao.ProductItemRepository;
import org.id.billingservice.dto.RequestProductItem;
import org.id.billingservice.dto.ResponseProductItem;
import org.id.billingservice.entities.Product;
import org.id.billingservice.entities.ProductItem;
import org.id.billingservice.mappers.ProductItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductItemServiceImpl implements ProductItemServiceI {
    private ProductItemRepository productItemRepository;
    private ProductItemMapper productItemMapper;
    private ProductRestClient productRestClient;

    public ProductItemServiceImpl(ProductItemRepository productItemRepository, ProductItemMapper productItemMapper, ProductRestClient productRestClient) {
        this.productItemRepository = productItemRepository;
        this.productItemMapper = productItemMapper;
        this.productRestClient = productRestClient;
    }

    @Override
    public List<ResponseProductItem> allProductItem() {
        List<ProductItem> productItems = productItemRepository.findAll();
        productItems.forEach(productItem ->{
            getProduct(productItem);
        });

        List<ResponseProductItem> responseProductItems = productItems.stream()
                .map(productItem -> productItemMapper.productItemToResponseProductItem(productItem))
                .collect(Collectors.toList());
        return responseProductItems;
    }

    @Override
    public ResponseProductItem showProductItem(Long productItemId) {
        ProductItem productItem = productItemRepository.findById(productItemId).orElse(null);
        getProduct(productItem);
        return productItemMapper.productItemToResponseProductItem(productItem);
    }


    void getProduct(ProductItem productItem){
        Product product = productRestClient.getProduct(productItem.getProductId());
        productItem.setProduct(product);
    }
}
