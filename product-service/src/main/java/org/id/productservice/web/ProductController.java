package org.id.productservice.web;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.id.productservice.dto.RequestProduct;
import org.id.productservice.dto.ResponsProduct;
import org.id.productservice.services.ProductServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductController {
    private ProductServiceI productServiceI;


    public ProductController(ProductServiceI productServiceI) {
        this.productServiceI = productServiceI;
    }

    @PostMapping("/CreateProduct")
    ResponsProduct createProduct(@RequestBody RequestProduct requestProduct){
        return  productServiceI.createProduct(requestProduct);
    }

    @GetMapping("/ShowProduct/{productId}")
    ResponsProduct showProduct(@PathVariable Long productId){
        return productServiceI.showProduct(productId);
    }

    @DeleteMapping("/DeleteProduct/{productId}")
    void delete(@PathVariable Long productId){
        productServiceI.deleteProduct(productId);
    }

    @GetMapping("/AllProducts")
    List<ResponsProduct> allProducts(){
        return productServiceI.allProduct();
    }

    @PutMapping("/UpdateProduct/{productId}")
    ResponsProduct updateProduct(@RequestBody RequestProduct requestProduct, @PathVariable Long productId){
        return productServiceI.updateProduct(requestProduct, productId);
    }
}
