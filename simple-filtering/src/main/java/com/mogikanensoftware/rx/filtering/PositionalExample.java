package com.mogikanensoftware.rx.filtering;

import com.mogikanensoftware.rx.util.FibonacciGenerator;

import rx.Observable;

public class PositionalExample {

	public static void main(String[] args) {

		System.out.println("First 6 numbers from Fib Seq");
		Observable.from(FibonacciGenerator.generateSequence(20)).take(7).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
		
		System.out.println("\nLast 4 numbers from Fib Seq");
		Observable.from(FibonacciGenerator.generateSequence(20)).takeLast(4).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
		
		System.out.println("\nFirst from Fib Seq");
		Observable.from(FibonacciGenerator.generateSequence(20)).first().subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
		
		System.out.println("\nFirst or default from empty");
		Observable.empty().firstOrDefault(26L).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
		
		System.out.println("\nLast or default from empty");
		Observable.empty().lastOrDefault(3000L).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});

		System.exit(0);
	}

}
