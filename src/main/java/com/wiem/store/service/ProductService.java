package com.wiem.store.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiem.store.entity.Product;
import com.wiem.store.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	ProductRepository productrepo;
		public Product createprod(Product prod) {
			return productrepo.save(prod);	
		}
		
		public List<Product> findAll(){
		return productrepo.findAll();
	}
		
		public void deleteprod(int id) {
		productrepo.deleteById(id);
			
		}
		public Product findById(int id) {
			Optional<Product> productOptional = productrepo.findById(id);
	        return productOptional.orElse(null);
		}
		
		

}
