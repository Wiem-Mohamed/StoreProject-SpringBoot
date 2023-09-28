package com.wiem.store.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wiem.store.entity.User;
import com.wiem.store.entity.UserRecord;
import com.wiem.store.exception.UserAlreadyExistsException;
import com.wiem.store.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User add(User user) throws UserAlreadyExistsException {

        Optional<User> theUser = userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<UserRecord> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserRecord(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
        		.orElseThrow(()-> new UsernameNotFoundException("User not found"));
                
    }

    @Override
    public User update(User user) {
        user.setRoles(user.getRoles());
        return userRepository.save(user);
    }
}

	
