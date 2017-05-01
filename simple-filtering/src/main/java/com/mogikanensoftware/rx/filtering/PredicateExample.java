package com.mogikanensoftware.rx.filtering;

import rx.Observable;

public class PredicateExample {

	public static void main(String[] args) {
		/**
		 * Create observable which using predicate to filter elements
		 * to the ones divisible by 17 and less then 900
		 */
		Observable.range(0, 1000).filter((i)->{
			return (i%17==0) && (i<900);
		}).subscribe((i)->{
			System.out.println(i);
		});

		System.exit(0);
	}

}
