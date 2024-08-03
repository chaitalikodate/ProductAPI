package com.restApi.ProductApiy.ServiceInterfaceImplimantation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.ProductApiy.Entity.Product;
import com.restApi.ProductApiy.Repository.ProductRepository;
import com.restApi.ProductApiy.ServiceInterface.ProductService;

@Service
public class ProductServiceImplimentation implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
		
	}

	@Override
	public List<Product> saveManyProducts(List<Product> product) {
		// TODO Auto-generated method stub
		return repo.saveAll(product);
	}
	
	

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	
	
	public List<Product> getByName(String name) {
		// TODO Auto-generated method stub
		List<Product> product=repo.findByName(name);
		return repo.saveAll(product);
	}

	@Override
	public List<Product> getByQuantity(int quantity) {
		// TODO Auto-generated method stub
		List<Product> prod=  repo.findByQuantity(quantity);
		return repo.saveAll(prod);
	}

	@Override
	public Product getByPrice(double price) {
		// TODO Auto-generated method stub
		return repo.findByPrice(price);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
		 return "deleted sussessfully"+id;
	}

	@Override
	public Product updateProduct(Product product) {
		System.out.println(product.getId());
		// TODO Auto-generated method stub
		Product existingProduct=repo.findById(product.getId()).orElse(null);
		System.out.println(existingProduct);
		if(existingProduct!=null) {
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repo.save(existingProduct);
		}
		return null;
	}

}
