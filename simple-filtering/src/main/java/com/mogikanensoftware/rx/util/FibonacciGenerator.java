package com.mogikanensoftware.rx.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciGenerator {

	public static List<Integer> generateSequence(int j) {
		List<Integer> result = new ArrayList<>();
		if (j < 0) {
			throw new RuntimeException(String.format("Invalid parameter n=%d", j));
		} else if (j == 0) {
			System.out.println("Empty sequence");
		} else if (j == 1) {
			result.add(0);
		} else if (j == 2) {
			result.addAll(Arrays.asList(0, 1));
		} else {
			result.addAll(Arrays.asList(0, 1));
			for (int i = 2; i < j; i++) {
				int val = result.get(i - 1) + result.get(i - 2);
				result.add(val);
			}
		}
		return result;

	}
}
