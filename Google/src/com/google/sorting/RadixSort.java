package com.google.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void radixSort(final int[] data) {
		final int max = findMax(data);
		final int min = findMin(data);
		final int[] buckets = new int[max - min + 1];
		for (final int value : data)
			++buckets[value - min];
		int pos = 0;
		for (int i = 0; i < buckets.length; ++i)
			for (int j = 0; j < buckets[i]; ++j)
				data[pos++] = min + i;
	}
	
	public static void main(String... args) {
		final int length = 30;
		int[] data = TestSorting.randomData2(length);
		System.out.println(Arrays.toString(data));
		radixSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	private static int findMax(final int[] data) {
		int max = 0;
		for (int i = 1; i < data.length; ++i)
			if (data[max] < data[i])
				max = i;
		return data[max];
	}

	private static int findMin(final int[] data) {
		int min = 0;
		for (int i = 1; i < data.length; ++i)
			if (data[min] > data[i])
				min = i;
		return data[min];
	}

}
