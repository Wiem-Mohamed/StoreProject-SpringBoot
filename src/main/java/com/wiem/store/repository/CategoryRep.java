package com.wiem.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiem.store.entity.Category;

@Repository
public interface CategoryRep  extends JpaRepository<Category, Integer>{

}
