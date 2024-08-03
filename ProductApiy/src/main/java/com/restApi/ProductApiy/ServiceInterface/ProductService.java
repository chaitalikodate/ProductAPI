package com.restApi.ProductApiy.ServiceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restApi.ProductApiy.Entity.Product;

@Service
public interface ProductService {
	
   public Product saveProduct(Product product);
   public List<Product> saveManyProducts(List<Product> product);
   
   public List<Product> getAllProduct();
   
   public Product getById(int id);
   
   
   public List<Product> getByName(String name);
   
   public List<Product> getByQuantity(int quantity);
   
   public Product getByPrice(double price);
   
   public String deleteById(int id);
   
   public Product updateProduct(Product product);
    
   
}
