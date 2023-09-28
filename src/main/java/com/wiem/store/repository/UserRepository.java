package com.wiem.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiem.store.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
    void deleteByEmail(String email);


}
