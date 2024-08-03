package com.restApi.ProductApiy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restApi.ProductApiy.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,  Integer> {
	
	@Query("Select p from Product p where p.name=?1")
    List<Product> findByName(String name);
    Product findByPrice(double price);
    List<Product> findByQuantity(int quantity);
}
