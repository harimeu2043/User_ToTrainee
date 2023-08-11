package com.infy.service;

import com.infy.dto.UserDTO;
import com.infy.exception.UsersException;

public interface UserService {
	public Integer addUser(UserDTO  userDTO) throws UsersException;
}
