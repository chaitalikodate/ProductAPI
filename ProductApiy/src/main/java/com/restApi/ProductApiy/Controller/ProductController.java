package com.restApi.ProductApiy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.ProductApiy.Entity.Product;
import com.restApi.ProductApiy.ServiceInterface.ProductService;

@RestController
public class ProductController {
	 @Autowired
	private ProductService service;
	 
	@PostMapping("/addProduct") 
    public Product addProduct(@RequestBody Product product) {
    	return service.saveProduct(product);
    }
    
	@PostMapping("/addProducts") 
    public List<Product> saveAllProduct(@RequestBody List<Product> products){
    	return service.saveManyProducts(products);
    	
    	
    }
    
	@GetMapping("/getAll")
    public List<Product> findAllProducts(){
    	return service.getAllProduct();
    }
	
	@GetMapping("/product/{id}")
	public Product findByID(@PathVariable int id) {
		return service.getById(id);
	}
	
	
	@GetMapping("/productName/{name}")
	public List<Product> findByNames(@PathVariable String name) {
		System.out.println(name);
		return service.getByName(name);
	}
	
	@GetMapping("/getByQuantity/{quantity}")
	public List<Product> findByQuantity(@PathVariable int quantity) {
		return service.getByQuantity(quantity);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	
}
