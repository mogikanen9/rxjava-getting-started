package com.mogikanensoftware.rx.filtering;

import com.mogikanensoftware.rx.util.FibonacciGenerator;

import rx.Observable;

public class PositionalElementAtExample {

	public static void main(String[] args) {
		Observable.from(FibonacciGenerator.generateSequence(20)).elementAt(6).subscribe((i) -> {
			System.out.println(String.format(" %d", i));
		});

		//element with index 2000 does not exist
		Observable.from(FibonacciGenerator.generateSequence(20)).elementAtOrDefault(2000, -7L)
				.subscribe((i) -> {
					System.out.println(String.format(" %d", i));
				});
		
		System.exit(0);
	}

}
