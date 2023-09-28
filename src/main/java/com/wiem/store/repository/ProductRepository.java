package com.wiem.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiem.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
