package com.mogikanensoftware.rx.service.client.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.mogikanensoftware.rx.service.client.ClientService;
import com.mogikanensoftware.rx.service.client.ToDoItem;

public class MultiThreadRun {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final ClientService client = new ClientService("http://localhost:8080/api/v1/todoitems/");

		long initTimePoint = System.currentTimeMillis();

		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<ToDoItem>> futureList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Future<ToDoItem> futureItem = executor.submit(new ToDoCallable(client, i));
			futureList.add(futureItem);
		}

		List<ToDoItem> myToDoItems = new ArrayList<>();
		for (Future<ToDoItem> futureItem : futureList) {
			myToDoItems.add(futureItem.get());
		}

		boolean allWereLoaded = client.listAll().size() == myToDoItems.size();
		long took = System.currentTimeMillis() - initTimePoint;
		System.out.println(String.format("All my ToDo items were loaded -> %s, took %d ms.", allWereLoaded, took));
		
		System.exit(0);
	}
}

class ToDoCallable implements Callable<ToDoItem> {

	private ClientService service;
	private int itemId;

	public ToDoCallable(final ClientService service, final int itemId) {
		super();
		this.service = service;
		this.itemId = itemId;
	}

	@Override
	public ToDoItem call() throws Exception {
		Optional<ToDoItem> item = service.getById(itemId);
		if (item.isPresent()) {
			return item.get();
		} else {
			throw new Exception(String.format("ToDo item with id->%d does not exist", itemId));
		}
	}

}