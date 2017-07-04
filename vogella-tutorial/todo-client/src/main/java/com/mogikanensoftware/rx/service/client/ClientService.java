package com.mogikanensoftware.rx.service.client;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientService {

	private String baseServiceUrl;
	
	
	public ClientService(final String baseServiceUrl) {
		super();
		this.baseServiceUrl = baseServiceUrl;
	}


	public List<ToDoItem> listAll() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ToDoItem[]> response = restTemplate.getForEntity(this.baseServiceUrl,
				ToDoItem[].class);
		return Arrays.asList(response.getBody());
	}

	
	public Optional<ToDoItem> getById(long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ToDoItem> response = restTemplate.getForEntity(this.baseServiceUrl+Long.toString(id),
				ToDoItem.class);
		ToDoItem result = response.getBody();
		System.out.println(String.format("result->%s", result.toString()));
		return result!=null?Optional.of(result):Optional.empty();
	}
}
