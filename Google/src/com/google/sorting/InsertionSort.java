package com.google.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(final int[] data) {
		insertionSort(data, 0, data.length - 1);
	}

	public static void insertionSort(final int[] data, final int left, final int right) {
		for (int i = left; i < right; ++i) {
			int min = i;
			for (int j = i + 1; j <= right; ++j)
				if (data[j] < data[min])
					min = j;
			swap(data, i, min);
		}
	}

	public static void main(final String... args) {
		final int length = 30;
		final int[] data = TestSorting.randomData(length);
		System.out.println(Arrays.toString(data));
		insertionSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	private static void swap(final int[] data, final int i, final int j) {
		if (i != j) {
			final int t = data[i];
			data[i] = data[j];
			data[j] = t;
		}
	}

}
