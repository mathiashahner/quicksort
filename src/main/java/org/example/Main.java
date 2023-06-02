package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int NUM_ELEMENTS = 10000;

	public static void main(String[] args) {

		int[] orderArray = getArray();
		int[] reverseArray = getReverseArray();
		int[] randomArray = getRandomArray();

		int numberSwaps;
		Instant startTime, finishTime;
		QuickSort quickSort = new QuickSort();

		startTime = Instant.now();
		numberSwaps = quickSort.quickSort(orderArray, 0, orderArray.length - 1);
		finishTime = Instant.now();
		System.out.println("Order: " + getElapsedTime(startTime, finishTime) + "ms - Swaps: " + numberSwaps);

		startTime = Instant.now();
		numberSwaps = quickSort.quickSort(reverseArray, 0, reverseArray.length - 1);
		finishTime = Instant.now();
		System.out.println("Reverse: " + getElapsedTime(startTime, finishTime) + "ms - Swaps: " + numberSwaps);

		startTime = Instant.now();
		numberSwaps = quickSort.quickSort(randomArray, 0, randomArray.length - 1);
		finishTime = Instant.now();
		System.out.println("Random: " + getElapsedTime(startTime, finishTime) + "ms - Swaps: " + numberSwaps);
	}

	private static double getElapsedTime(Instant startTime, Instant finishTime) {
		return Duration.between(startTime, finishTime).toMillis();
	}

	private static int[] getArray() {
		int[] arr = new int[NUM_ELEMENTS];

		for (int i = 0; i < NUM_ELEMENTS; i++)
			arr[i] = i;
		return arr;
	}

	private static int[] getReverseArray() {
		int[] arr = new int[NUM_ELEMENTS];

		for (int i = NUM_ELEMENTS - 1; i > 0; i--)
			arr[i - 1] = NUM_ELEMENTS - i;
		return arr;
	}

	private static int[] getRandomArray() {
		int[] arr = new int[NUM_ELEMENTS];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < NUM_ELEMENTS; i++)
			list.add(i);
		Collections.shuffle(list);

		for (int i = 0; i < NUM_ELEMENTS; i++)
			arr[i] = list.get(i);
		return arr;
	}
}
