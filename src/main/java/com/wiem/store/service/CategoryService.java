package com.wiem.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiem.store.entity.Category;
import com.wiem.store.repository.CategoryRep;

@Service
public class CategoryService {
@Autowired
CategoryRep categoryrep;
	public Category createcat(Category cat) {
		return categoryrep.save(cat);	
	}
	
	public List<Category> findAll(){
	return categoryrep.findAll();
}
	

	public void deletecat(int id) {
	categoryrep.deleteById(id);
		
		
	}
	public Category findById(int id) {
		Optional<Category> categoryOptional = categoryrep.findById(id);
        return categoryOptional.orElse(null);
	}
	
	

}
