package com.mogikanensoftware.rx.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciGenerator {

	List<Integer> generateSequence(short n) {
		List<Integer> result = new ArrayList<>();
		if (n < 0) {
			throw new RuntimeException(String.format("Invalid parameter n=%d", n));
		} else if (n == 0) {
			System.out.println("Empty sequence");
		} else if (n == 1) {
			result.add(0);
		} else if (n == 2) {
			result.addAll(Arrays.asList(0, 1));
		} else {
			result.addAll(Arrays.asList(0, 1));
			for (int i = 2; i < n; i++) {
				int val = (i - 1) + (i - 2);
				result.add(val);
			}
		}
		return result;

	}
}
