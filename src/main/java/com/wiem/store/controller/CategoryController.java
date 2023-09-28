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

import com.wiem.store.entity.Category;
import com.wiem.store.service.CategoryService;
@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryservice;
	@PostMapping("/add")
	public Category createcat(@RequestBody Category cat) {
		return categoryservice.createcat(cat);
			
	}
	@GetMapping("/list")
	public List<Category> listCategory() {
		return categoryservice.findAll();
		
	}
	@DeleteMapping("/delete/{id}")
	public void delete( @PathVariable int id) {
		categoryservice.deletecat(id);	
	}
	 @GetMapping("find/{id}")
	 public Category getCategoryById(@PathVariable int id) {
	       return categoryservice.findById(id);
	    }
	
	

}
