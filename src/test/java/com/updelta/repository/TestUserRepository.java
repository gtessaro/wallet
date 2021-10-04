package com.updelta.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.updelta.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {

	private final String EMAIL = "email.@teste.com";
	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		User u = new User();
		u.setName("setUp User");
		u.setPassword("senha123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		assertNotNull(response);
	}
	
	public void testFindByMail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(),EMAIL);
	}
	
}
