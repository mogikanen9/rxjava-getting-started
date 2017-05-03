package com.mogikanensoftware.rx.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciGenerator {

	public static List<Long> generateSequence(int j) {
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
				result.add(val);
			}
		}
		return result;

	}
}
