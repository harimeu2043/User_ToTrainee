package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserDTO;
import com.infy.exception.UsersException;
import com.infy.repository.UserRepository;
import com.infy.validator.Validator;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Integer addUser(UserDTO  userDTO) throws UsersException {
		Validator.validate(userDTO);
		return userRepository.addUser(userDTO);
	}
}
