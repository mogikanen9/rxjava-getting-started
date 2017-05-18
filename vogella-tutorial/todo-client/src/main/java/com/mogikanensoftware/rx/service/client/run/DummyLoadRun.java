package com.mogikanensoftware.rx.service.client.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mogikanensoftware.rx.service.client.ClientService;
import com.mogikanensoftware.rx.service.client.ToDoItem;

public class DummyLoadRun {

	public static void main(String[] args) {

		ClientService client = new ClientService(ClientSettings.SERVICE_URL);

		long initTimePoint = System.currentTimeMillis();
		List<ToDoItem> myToDoItem = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			long oneCallStartTime = System.currentTimeMillis();

			Optional<ToDoItem> item = client.getById(i);

			long oneCallTook = System.currentTimeMillis() - oneCallStartTime;
			System.out.println(String.format("One call took ->%d ms.", oneCallTook));

			if (item.isPresent()) {
				myToDoItem.add(item.get());
			} else {
				System.err.println(String.format("ToDo item with id->%d does not exist", i));
			}
		}

		boolean allWereLoaded = client.listAll().size() == myToDoItem.size();
		long took = System.currentTimeMillis() - initTimePoint;
		System.out.println(String.format("All my ToDo items were loaded -> %s, took %d ms.", allWereLoaded, took));

		System.exit(0);
	}

}
