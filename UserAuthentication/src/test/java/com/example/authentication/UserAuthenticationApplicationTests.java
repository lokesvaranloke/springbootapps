package com.example.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.authentication.entity.User;
import com.example.authentication.repository.UserRepository;
import com.example.authentication.service.UserService;

@SpringBootTest
class UserAuthenticationApplicationTests {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	UserService service;
	
	@Test
	void isUser() {
		User user = new User();

		user.setName("User");
		user.setEmail("user@gmail.com");
		user.setPassword("user123");
		assertEquals("User",user.getName());
		assertEquals("user@gmail.com",user.getEmail());
		assertEquals("user123", user.getPassword());
	}
	@Test
	void testServiceCall() {
		Iterable<User> users = service.GetAllUsers();
		Integer count = 0;
		
		for(User u: users)
			count++;
		
		assertNotEquals(count, 0);
	}
	
	@Test
	void countUsers() {
		Iterable<User> users = service.GetAllUsers();
		Integer count = 0;
		
		for(User u: users)
			count++;
		
		assertEquals(count, 4);
	}
	
	@Test
	void checkAllUsers() {
		Iterable<User> users = service.GetAllUsers();
		
		for(User u: users)
			assertNotNull(u);
	}
	 @Test
	    public void passwordNotNull() {
	    	
			Iterable<User> users = repo.findAll();
			for(User u: users)
				assertNotNull(u.getPassword());
	    }

	    @Test
	    public void nameNotNull() {
	    	
			Iterable<User> users = repo.findAll();
			for(User u: users)
				assertNotNull(u.getName());
	    }

	    @Test
	    public void emailNotNull() {
	    	
			Iterable<User> users = repo.findAll();
			for(User u: users)
				assertNotNull(u.getEmail());
	    }

}
