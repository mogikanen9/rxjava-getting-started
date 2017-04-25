package com.mogikanensoftware.rx.creation;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class SubscribeOnThreadExample {

	public static void main(String[] args) {
		System.out.println(String.format("Currrent thread ->%s", Thread.currentThread().getName()));

		List<Integer> fibonacciList = Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34);

		Observable<Integer> observableList = Observable.from(fibonacciList);

		observableList
				.subscribeOn(Schedulers.newThread())
				// .subscribeOn(Schedulers.io())
				.subscribe((i) -> {
					System.out.println(i);
					System.out.println(String.format("Currrent thread ->%s", Thread.currentThread().getName()));
				}, (t) -> {
					t.printStackTrace();
				}, () -> {
					System.out.println("Complete");
				});

		System.exit(0);
	}
}
