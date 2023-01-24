package org.id.billingservice.web;

import org.id.billingservice.dto.ResponseProductItem;
import org.id.billingservice.entities.ProductItem;
import org.id.billingservice.services.ProductItemServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductItemCotroller {
    private ProductItemServiceI productItemServiceI;

    public ProductItemCotroller(ProductItemServiceI productItemServiceI) {
        this.productItemServiceI = productItemServiceI;
    }

    @GetMapping("/AllProductItem")
    List<ResponseProductItem> allProduct(){
        return productItemServiceI.allProductItem();
    }

    @GetMapping("/ShowProductitem/{productItemId}")
    ResponseProductItem showProductItem(@PathVariable Long protuctItemId){
        return productItemServiceI.showProductItem(protuctItemId);
    }
}
