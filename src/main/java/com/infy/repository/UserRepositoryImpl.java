package com.infy.repository;

import org.springframework.stereotype.Repository;

import com.infy.dto.UserDTO;
import com.infy.exception.UsersException;

@Repository("value=userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	public Integer addUser(UserDTO  userDTO) throws UsersException {
		return userDTO.getUserId();
	}
}
 