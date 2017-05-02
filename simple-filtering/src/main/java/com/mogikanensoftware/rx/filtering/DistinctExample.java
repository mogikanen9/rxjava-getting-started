package com.mogikanensoftware.rx.filtering;

import java.util.ArrayList;
import java.util.List;

import com.mogikanensoftware.rx.util.FibonacciGenerator;

import rx.Observable;

public class DistinctExample {

	public static void main(String[] args) {
		
		List<Long> tipleFibList = new ArrayList<>();
		tipleFibList.addAll(FibonacciGenerator.generateSequence(10));
		tipleFibList.addAll(FibonacciGenerator.generateSequence(10));
		tipleFibList.addAll(FibonacciGenerator.generateSequence(10));
		
		// full
		Observable.from(tipleFibList).subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});
		System.out.println("\n Distinct:");
		// distinct
		Observable.from(tipleFibList).distinct().subscribe((i) -> {
			System.out.print(String.format(" %d", i));
		});

		System.exit(0);
	}

}
