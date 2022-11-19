package com.proxy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.proxy.api.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration

public class UserServiceTest {

	@Autowired
	public UserService User;
	public Github git;
	
	@Test
	public void listaDeUsuariosTest() {
	 User.listaDeUsuarios(3L);
	 assertEquals("mojombo",git.getLogin());
	}
}
