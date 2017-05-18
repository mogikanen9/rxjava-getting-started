package com.mogikanensoftware.rx.service.client.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mogikanensoftware.rx.service.client.ClientService;
import com.mogikanensoftware.rx.service.client.ToDoItem;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class RxSimpleCreateRun {

	public static void main(String[] args) {
		final ClientService client = new ClientService(ClientSettings.SERVICE_URL);

		long initTimePoint = System.currentTimeMillis();

		List<Observable<ToDoItem>> observableFutureList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			Observable<ToDoItem> observableItem = Observable.create(new ToDoObservableOnSubscribe(client,i));
			observableFutureList.add(observableItem);
		}
		System.out.println("All observables were created...");
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

class ToDoObservableOnSubscribe implements ObservableOnSubscribe<ToDoItem> {

	private ClientService client;
	private int id;

	public ToDoObservableOnSubscribe(final ClientService client, final int id) {
		super();
		this.client = client;
		this.id = id;
	}

	@Override
	public void subscribe(ObservableEmitter<ToDoItem> emiter) throws Exception {
		long oneCallStartTime = System.currentTimeMillis();

		Optional<ToDoItem> item = client.getById(id);

		long oneCallTook = System.currentTimeMillis() - oneCallStartTime;
		System.out.println(String.format("One call took ->%d ms.", oneCallTook));

		if (item.isPresent()) {
			emiter.onNext(item.get());
		} else {
			System.err.println(String.format("ToDo item with id->%d does not exist", id));
		}
		emiter.onComplete();
	}

}
