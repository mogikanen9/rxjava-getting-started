package com.mogikanensoftware.rx.utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;

public class TimeoutExample {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Example with timeout");
		Observable.from(FibonacciGenerator.generateSequence(20)).timeout(1, TimeUnit.SECONDS).subscribe((el) -> {
			System.out.println(String.format("%d was printed, press ENTER to conitnue", el));
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.exit(0);

	}

}
