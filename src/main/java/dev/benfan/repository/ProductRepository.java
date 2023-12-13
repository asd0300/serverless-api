package dev.benfan.repository;

import dev.benfan.models.Product;
//import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameLike(String productName);
    List<Product> findByIdIn(List<String> ids);
//    boolean existByEmail(String email);
//    Optional<User> findByUsernameAndPassword(String email, String pwd);
//    //查詢name 字串 包含參數的文件不分大小
    @Query("{'name': {'$regex':?0, '$option': 'i'}}")
    List<Product> findByNameLikeIgnoreCase(String name, Sort sort);
    //查詢價格介於
    @Query("{'price':{'$gte': ?0, '$lte': ?1}}")
    List<Product> findByPriceBetween(int from , int to);

    // 查詢 name 字串欄位有包含參數的文件，不分大小寫
    @Query("{'name': {'$regex': ?0, '$options': 'i'}}")
    List<Product> findByNameLikeIgnoreCase(String name);

    // 查詢同時符合上述兩個條件的文件
    @Query("{'$and': [{'price': {'$gte': ?0, '$lte': ?1}}, {'name': {'$regex': ?2, '$options': 'i'}}]}")
    List<Product> findByPriceBetweenAndNameLikeIgnoreCase(int priceFrom, int priceTo, String name, Sort sort);

    // 回傳 id 欄位值有包含在參數之中的文件數量
    @Query(value = "{'_id': {'$in': ?0}}", count = true)
    int countByIdIn(List<String> ids);

    // 回傳是否有文件的 id 欄位值包含在參數之中
    @Query(value = "{'_id': {'$in': ?0}}", exists = true)
    boolean existsByIdIn(List<String> ids);

    // 刪除 id 欄位值包含在參數之中的文件
    @Query(delete = true)
    void deleteByIdIn(List<String> ids);

    // 找出 id 欄位值有包含在參數之中的文件，且先以 name 欄位遞增排序，再以 price 欄位遞減排序
    @Query(sort = "{'name': 1, 'price': -1}")
    List<Product> findByIdInOrderByNameAscPriceDesc(List<String> ids);
}
