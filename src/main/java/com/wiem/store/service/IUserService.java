package com.wiem.store.service;

import java.util.List;

import com.wiem.store.entity.User;
import com.wiem.store.entity.UserRecord;
import com.wiem.store.exception.UserAlreadyExistsException;

public interface IUserService {
	 User add(User user) throws UserAlreadyExistsException;
	    List<UserRecord> getAllUsers();
	    void delete(String email);
	   User getUser(String email);
	    User update(User user);

}
