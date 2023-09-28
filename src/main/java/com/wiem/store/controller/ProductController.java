package com.wiem.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wiem.store.entity.Product;

import com.wiem.store.service.ProductService;
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productservice;
	@PostMapping("/add")
	public Product createprod(@RequestBody Product prod) {
		return productservice.createprod(prod);
			
	}
	@GetMapping("/list")
	public List<Product> listProduct() {
		return productservice.findAll();
		
	}
	@DeleteMapping("/delete/{id}")
	public void delete( @PathVariable int id) {
		productservice.deleteprod(id);	
	}
	 @GetMapping("find/{id}")
	 public Product getProductById(@PathVariable int id) {
	       return productservice.findById(id);
	    }

}
