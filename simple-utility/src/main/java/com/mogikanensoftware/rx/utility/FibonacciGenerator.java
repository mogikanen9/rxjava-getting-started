package com.mogikanensoftware.rx.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciGenerator {

	public static List<Long> generateSequence(int j) {
		System.out.println(
				String.format("Generating Fib sequence for %d in Thread->%s", j, Thread.currentThread().getName()));
		List<Long> result = new ArrayList<>();
		if (j < 0) {
			throw new RuntimeException(String.format("Invalid parameter n=%d", j));
		} else if (j == 0) {
			System.out.println("Empty sequence");
		} else if (j == 1) {
			result.add(0L);
		} else if (j == 2) {
			result.addAll(Arrays.asList(0L, 1L));
		} else {
			result.addAll(Arrays.asList(0L, 1L));
			for (int i = 2; i < j; i++) {
				long val = result.get(i - 1) + result.get(i - 2);
				if (val == 377) {
					System.out.println(
							String.format("Sleep for 3 seconds in Thread->%s", Thread.currentThread().getName()));
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				result.add(val);
			}
		}
		return result;

	}
}
