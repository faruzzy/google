package com.google.sorting;

import java.util.Arrays;

public class GenericQuickSort {

	public static void main(final String... args) {
		final String[] data = { "Hello", "There", "world", "Aaa", "BCD", "E", "Yes", "e", "103", "nine" };
		System.out.println(Arrays.toString(data));
		quickSort(data, 0, data.length - 1);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void quickSort(final Comparable<T>[] data, final int left, final int right) {
		if (right - left < 1)
			return;
		if (right == left + 1) {
			if (data[right].compareTo((T) data[left]) < 0)
				swap(data, left, right);
			return;
		}

		final int pivot = pickPivot(left, right);
		final int index = partition(data, left, right, pivot);

		quickSort(data, left, index - 1);
		quickSort(data, index + 1, right);
	}

	private static <T extends Comparable<T>> int partition(final Comparable<T>[] data, final int left, final int right, final int pivot) {
		@SuppressWarnings("unchecked")
		final T value = (T) data[pivot];
		swap(data, left, pivot);
		int l = left + 1;
		int r = right;
		for (;;) {
			while (l <= right && data[l].compareTo(value) <= 0)
				l++;
			while (data[r].compareTo(value) > 0)
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

	private static <T extends Comparable<T>> void swap(final Comparable<T>[] data, final int i, final int j) {
		if (i != j) {
			final Comparable<T> temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

}
