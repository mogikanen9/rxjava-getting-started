package com.mogikanensoftware.rx.service.client.run;

import java.util.Optional;

import com.mogikanensoftware.rx.service.client.ClientService;
import com.mogikanensoftware.rx.service.client.ToDoItem;

public class MainRun {

	public static void main(String[] args) {
		
		ClientService client = new ClientService("http://localhost:8080/api/v1/todoitems/");
		Optional<ToDoItem> item2 = client.getById(2);
		System.out.println(item2.isPresent());
		if(item2.isPresent()){
			System.out.println(item2.get());
		}else{
			System.out.println("nothing :(");
		}
		
		System.out.println("*****************************************************");
		client.listAll().forEach(System.out::println);
	}

}
