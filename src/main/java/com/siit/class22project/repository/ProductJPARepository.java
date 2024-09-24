package com.siit.class22project.repository;

import com.siit.class22project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCTS")
    List<Product> getProductsByMySpecialQuery();

    @Query(nativeQuery = false, value = "SELECT p FROM Product p")
    List<Product> getProductsByMySpecialQueryHql();
}
