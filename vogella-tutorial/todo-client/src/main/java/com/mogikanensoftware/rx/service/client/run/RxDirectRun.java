package com.mogikanensoftware.rx.service.client.run;

import java.util.ArrayList;
import java.util.List;

import com.mogikanensoftware.rx.service.client.ClientService;
import com.mogikanensoftware.rx.service.client.ToDoItem;

import io.reactivex.Observable;

public class RxDirectRun {

	public static void main(String[] args) {
		final ClientService client = new ClientService(ClientSettings.SERVICE_URL);

		long initTimePoint = System.currentTimeMillis();

		List<Observable<ToDoItem>> observableFutureList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			Observable<ToDoItem> observableItem = Observable.fromCallable(new ToDoCallable(client, i));
			observableFutureList.add(observableItem);
		}

		List<ToDoItem> myToDoItems = new ArrayList<>();
		for (Observable<ToDoItem> observableItem : observableFutureList) {

			long oneCallStartTime = System.currentTimeMillis();

			observableItem.subscribe(emiter -> myToDoItems.add(emiter));

			long oneCallTook = System.currentTimeMillis() - oneCallStartTime;
			System.out.println(String.format("One subscribtion took ->%d ms.", oneCallTook));

		}

		boolean allWereLoaded = client.listAll().size() == myToDoItems.size();
		long took = System.currentTimeMillis() - initTimePoint;
		System.out.println(String.format("All my ToDo items were loaded -> %s, took %d ms.", allWereLoaded, took));

		System.exit(0);
	}
}
