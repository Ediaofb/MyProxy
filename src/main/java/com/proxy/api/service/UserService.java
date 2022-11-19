package com.proxy.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	public Object listaDeUsuarios(Long quantidade) {
		String url = "https://api.github.com/users?since" + quantidade;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> respostaEntity = restTemplate.getForEntity(url, Object.class);
		return respostaEntity.getBody();
	}

	public Object consultarDetalheDeUsuario(String nomeDoUsuario) {
		String url = "https://api.github.com/users/" + nomeDoUsuario + "/details";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> respostaEntity = restTemplate.getForEntity(url, Object.class);
		return respostaEntity.getBody();
	}

	public Object consultarRepositorios(String nomeDoUsuario) {
		String url = "https://api.github.com/users/" + nomeDoUsuario + "/repos";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> respostaEntity = restTemplate.getForEntity(url, Object.class);
		return respostaEntity.getBody();
	}

}