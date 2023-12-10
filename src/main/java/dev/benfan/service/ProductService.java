package dev.benfan.service;

import dev.benfan.models.Product;
import dev.benfan.models.ProductQueryParameter;
import dev.benfan.models.ProductRequest;
import dev.benfan.repository.ProductRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product getProduct(String id){
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find product."));
    }

    public Product createProduct(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return productRepository.insert(product);
    }
    public Product replaceProduct(Product request){
        String id = request.getOldid();
        Product oldproduct = getProduct(id);

        Product product = new Product();
        product.setId(oldproduct.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return productRepository.save(product);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    public List<Product> getProducts(ProductQueryParameter param){
        String keyword = Optional.ofNullable(param.getKeyword()).orElse("");
        int priceFrom = Optional.ofNullable(param.getPriceFrom()).orElse(0);
        int priceTo = Optional.ofNullable(param.getPriceTo()).orElse(Integer.MAX_VALUE);

        Sort sort = genSortingStrategy(param.getOrderBy(), param.getSortRule());

        return  productRepository.findByPriceBetweenAndNameLikeIgnoreCase(priceFrom, priceTo, keyword, sort);
    }

    private Sort genSortingStrategy(String orderBy, String sortRule) {
        Sort sort = Sort.unsorted();
        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
            Sort.Direction direction = Sort.Direction.fromString(sortRule);
            sort = Sort.by(direction, orderBy);
        }
        return sort;
    }
}
