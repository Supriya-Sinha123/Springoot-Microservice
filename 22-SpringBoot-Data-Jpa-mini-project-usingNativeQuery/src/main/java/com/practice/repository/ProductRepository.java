package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET name = :name, model = :model, price = :price, mfd = :mfd, warranty = :warranty WHERE id = :id", nativeQuery = true)
    void updateProduct(@Param("id") Long id,
                           @Param("name") String name,
                           @Param("model") String model,
                           @Param("price") String price,
                           @Param("mfd") String mfd,
                           @Param("warranty") int warranty);
    
    @Query(value = "SELECT * FROM products WHERE id = :id", nativeQuery = true)
    ProductEntity getProductById(@Param("id") Long id);
    
    @Modifying
    @Transactional
    @Query(value="DELETE from products WHERE id = :id", nativeQuery = true)
    void deleteProduct(@Param("id")Long id);
    
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<ProductEntity> getAllProducts();
}
