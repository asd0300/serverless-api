package dev.benfan.convert;

import dev.benfan.models.Product;
import dev.benfan.models.ProductRequest;

public class ProductConverter {
    private ProductConverter() {

    }
    public static Product toProduct(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }
}
