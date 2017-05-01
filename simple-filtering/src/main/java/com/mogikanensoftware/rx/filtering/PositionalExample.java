package com.mogikanensoftware.rx.filtering;

import com.mogikanensoftware.rx.util.FibonacciGenerator;

import rx.Observable;

public class PositionalExample {

	public static void main(String[] args) {

		System.out.println("First 6 numbers form Fib Seq");
		Observable.from(FibonacciGenerator.generateSequence(20)).take(7).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
		
		System.out.println("\nLast 4 numbers form Fib Seq");
		Observable.from(FibonacciGenerator.generateSequence(20)).takeLast(4).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});

	}

}
