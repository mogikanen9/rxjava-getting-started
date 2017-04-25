package com.mogikanensoftware.rx.creation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;

import rx.Observable;
import rx.schedulers.Schedulers;

public class FutureExampleCreation {

	public static void main(String[] args) {

		FutureTask<List<Integer>> futureTask = new FutureTask<List<Integer>>(() -> {
			return Arrays.asList(789, 90, 123);
		});
		System.out.println("Future task was created");

		Observable<List<Integer>> observableFutureList = Observable.from(futureTask);
		System.out.println("Observable was created");

		Schedulers.computation().createWorker().schedule(() -> {
			futureTask.run();
		});
		System.out.println("Scheduller/Worker was scheduled");

		observableFutureList.subscribe((list) -> {
			list.forEach((item) -> {
				System.out.println(item);
			});
		});

		System.out.println("Done.");

		System.exit(0);
	}

}
