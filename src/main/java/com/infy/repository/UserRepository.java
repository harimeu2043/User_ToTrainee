package com.infy.repository;

import com.infy.dto.UserDTO;
import com.infy.exception.UsersException;

public interface UserRepository {

	public Integer addUser(UserDTO  userDTO) throws UsersException;

}
