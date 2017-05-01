package com.mogikanensoftware.rx.filtering;

import com.mogikanensoftware.rx.util.FibonacciGenerator;

import rx.Observable;

public class PositionalAndPredicateExample {

	public static void main(String[] args) {

		Observable.from(FibonacciGenerator.generateSequence(20)).first((i) -> {
			return i % 3 == 0;
		}).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
	}
}
