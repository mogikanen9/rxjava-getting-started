package com.mogikanensoftware.rx.utility;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

public class TimeoutExample {

	public static void main(String[] args) throws IOException, InterruptedException {

		Callable<List<Long>> callableFib = new Callable<List<Long>>() {

			@Override
			public List<Long> call() throws Exception {
				return FibonacciGenerator.generateSequence(20);
			}
		};

		System.out.println("Example with timeout");
		Observable.fromCallable(callableFib).subscribeOn(Schedulers.newThread())
		//.timeout(2, TimeUnit.SECONDS) //uncomment to get TimeoutException
		.timeout(5, TimeUnit.SECONDS)
				.subscribe((el) -> {
					System.out.println(el);
				});

		System.out.println("Yo-ho-ho and a botle of rum!");
		try {
			System.out.println(String.format("Press ENTER to continue (Thread->%s)",Thread.currentThread().getName()));
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.exit(0);

	}

}
