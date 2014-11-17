package com.google.sorting;

import java.util.Arrays;

public class QuickSort3Way {

	public static void main(final String... args) {
		final int length = 30;
		final int[] data = TestSorting.randomData2(length);
		System.out.println(Arrays.toString(data));
		quickSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	public static void quickSort(final int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	private static int pickPivot(final int[] data, final int left, final int right) {
		return data[left + (int) ((right - left + 1) * Math.random())];
	}

	private static void quickSort(final int[] data, final int left, final int right) {
		if (right - left < 1)
			return;

		if (right == left + 1) {
			if (data[left] > data[right])
				swap(data, left, right);
			return;
		}

		final int value = pickPivot(data, left, right);
		int l = left; // everybody to left of l is < value
		int r = right; // everybody to right of r is > value
		
		int i = left; // everybody to left of i has been processed
		while (i <= r) {
			if (data[i] < value)
				swap(data, i++, l++);
			else if (data[i] > value)
				swap(data, i, r--);
			else
				i++;
		}
		
		quickSort(data, left, l - 1);
		quickSort(data, r + 1, right);
	}

	private static void swap(final int[] data, final int i, final int j) {
		if (i != j) {
			final int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

}
