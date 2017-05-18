package com.mogikanensoftware.rx.service.client.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.FutureTask;

import com.mogikanensoftware.rx.service.client.ClientService;
import com.mogikanensoftware.rx.service.client.ToDoItem;

import io.reactivex.Observable;

public class RxDirectRun {

	public static FutureTask<ToDoItem> createFutureTask(final ClientService client, final int id) {
		return new FutureTask<ToDoItem>(() -> {
			Optional<ToDoItem> item = client.getById(id);
			if (item.isPresent()) {
				return item.get();
			} else {
				throw new Exception(String.format("ToDo item with id->%d does not exist", id));
			}
		});
	}

	public static void main(String[] args) {
		final ClientService client = new ClientService("http://localhost:8080/api/v1/todoitems/");

		long initTimePoint = System.currentTimeMillis();

		List<Observable<ToDoItem>> observableFutureList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			Observable<ToDoItem> observableItem = Observable.fromCallable(new ToDoCallable(client, i));
			observableFutureList.add(observableItem);
		}

		List<ToDoItem> myToDoItems = new ArrayList<>();
		for (Observable<ToDoItem> observableItem : observableFutureList) {
			observableItem.subscribe(emiter -> myToDoItems.add(emiter));
		}

		boolean allWereLoaded = client.listAll().size() == myToDoItems.size();
		long took = System.currentTimeMillis() - initTimePoint;
		System.out.println(String.format("All my ToDo items were loaded -> %s, took %d ms.", allWereLoaded, took));
		
		System.exit(0);
	}
}

