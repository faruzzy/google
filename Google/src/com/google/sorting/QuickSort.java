package com.google.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(final String... args) {
		final int length = 30;
		final int[] data = TestSorting.randomData(length);
		System.out.println(Arrays.toString(data));
		quickSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	public static void quickSort(final int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	private static int partition(final int[] data, final int left, final int right, final int pivot) {
		final int value = data[pivot];
		swap(data, left, pivot);
		int l = left + 1;
		int r = right;
		for (;;) {
			while (l <= right && data[l] <= value)
				l++;
			while (data[r] > value)
				r--;
			if (r <= l)
				break;
			swap(data, l, r);
		}
		swap(data, left, r);
		return r;
	}

	private static int pickPivot(final int left, final int right) {
		return left + (int) ((right - left + 1) * Math.random());
	}

	private static void quickSort(final int[] data, final int left, final int right) {
		if (right - left < 3) {
			InsertionSort.insertionSort(data, left, right);
			return;
		}

		final int pivot = pickPivot(left, right);
		final int index = partition(data, left, right, pivot);

		quickSort(data, left, index - 1);
		quickSort(data, index + 1, right);
	}

	private static void swap(final int[] data, final int i, final int j) {
		if (i != j) {
			final int t = data[i];
			data[i] = data[j];
			data[j] = t;
		}
	}

}
