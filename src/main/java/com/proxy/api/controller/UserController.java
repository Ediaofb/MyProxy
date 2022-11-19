package com.proxy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proxy.api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping
	public ResponseEntity<?> consultaUser(@RequestParam Long quantidade) {
		Object retornObject = userService.listaDeUsuarios(quantidade);
		return ResponseEntity.ok().body(retornObject);//respondendo com 'ok'à chamada da página web. 
	}

	@GetMapping("/{username}/details")//Cria o endpoint details passando a variável "username"
	public ResponseEntity<?> detalheDeUsuario(@PathVariable String username) {//Respondendo com objeto desconhecido. PathVariable pega a variável username 
		Object retornObject = userService.consultarDetalheDeUsuario(username);//pegando detalhe do usuário do username determinado
		return ResponseEntity.ok().body(retornObject);
	}

	@GetMapping("/{username}/repos")//Busca um "username" no endpoint details
	public ResponseEntity<?> repositorioDeUsuario(@PathVariable String username) {
 		Object retornObject = userService.consultarRepositorios(username);
		return ResponseEntity.ok().body(retornObject);
	}
}
