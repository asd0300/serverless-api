package dev.benfan.controller;

import dev.benfan.models.Product;
import dev.benfan.models.ProductQueryParameter;
import dev.benfan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/createProducts")
    public Product CreateProduct(@RequestBody Product request){
        return productService.createProduct(request);
    }
    @PostMapping("/GetProductsByPrice")
    public List<Product> GetProductsByPrice(@RequestBody ProductQueryParameter request){
        return productService.getProducts(request);
    }
    @PostMapping("/UpdateProduct")
    public Product UpdateProduct(@RequestBody Product request){

        return productService.replaceProduct(request);
    }
    @PostMapping("/FindProdcut")
    public Product FindProdcut(@RequestBody Product request){
        String id = request.getId();
        return productService.getProduct(id);
    }
    @PostMapping("/DeleteProdcut")
    public void DeleteProdcut(@RequestBody Product request){
        String id = request.getId();
        productService.deleteProduct(id);
    }
}
