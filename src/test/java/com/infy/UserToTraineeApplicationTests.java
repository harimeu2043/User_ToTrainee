package com.infy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.AddressDTO;
import com.infy.dto.UserDTO;
import com.infy.exception.UsersException;
import com.infy.repository.UserRepository;
import com.infy.service.UserService;
import com.infy.service.UserServiceImpl;


@SpringBootTest
class UserToTraineeApplicationTests {
	
	@Mock
	UserRepository repo;
	
	@InjectMocks
	UserService serv=new UserServiceImpl();
	
	UserDTO user;
	
	@BeforeEach
	void flibberyGibbits() throws UsersException {
		user = new UserDTO();
		user.setEmail("james@yahoo.in");
		user.setMobileNumber("3335651233");
		user.setPassword("James@123");
		user.setUserId(1008);
		user.setUserName("James");
		AddressDTO a = new AddressDTO();
		a.setAddressId(0);
		a.setCity("Phoenix");
		a.setDoorNumber("108A");
		a.setState("Arizona");
		a.setStreet("Fifth Main Street");
		a.setZipCode(85003);
		user.setAddress(a);
		
		Mockito.when(repo.addUser(user)).thenReturn(user.getUserId());
		
	}
	
	@Test
	void addUserValidTest() throws UsersException {
		Assertions.assertEquals(1008, serv.addUser(user));
	
	}

	@Test
	void addUserInvalidUserNameTest() throws UsersException {
		user.setUserName("James8");
		UsersException e = Assertions.assertThrows(UsersException.class, ()->serv.addUser(user));
		Assertions.assertEquals("Validator.INVALID_USERNAME", e.getMessage());
	
	}

	@Test
	void addUserInvalidPasswordTest() throws UsersException {
		user.setPassword("ames@ 1");
		UsersException e = Assertions.assertThrows(UsersException.class, ()->serv.addUser(user));
		Assertions.assertEquals("Validator.INVALID_PASSWORD", e.getMessage());
	}

	@Test
	void addUserInvalidEmailTest() throws UsersException {
		user.setEmail(" james@yahoo");
		UsersException e = Assertions.assertThrows(UsersException.class, ()->serv.addUser(user));
		Assertions.assertEquals("Validator.INVALID_EMAIL", e.getMessage());
	}

	@Test
	void addUserInvalidMobileNumberTest() throws UsersException {
		user.setMobileNumber("333565123");
		UsersException e = Assertions.assertThrows(UsersException.class, ()->serv.addUser(user));
		Assertions.assertEquals("Validator.INVALID_MOBILENO", e.getMessage());
	}

	@Test
	void addUserInvalidAddressTest() throws UsersException {
		user.getAddress().setZipCode(850093);
	
		UsersException e = Assertions.assertThrows(UsersException.class, ()->serv.addUser(user));
		Assertions.assertEquals("Validator.INVALID_ADDRESS", e.getMessage());
	}

}