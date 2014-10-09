package com.google.sort;

import java.util.Arrays;

/**
 * Quick Sort (sorta...)
 *
 * @author Matthew Robertson
 */
public class QuickSort {

	private final int[] data;

	public QuickSort(final int... data) {
		this.data = data;
	}

	public static void main(final String... args) {
		for (int i = 0; i < 30; ++i) {
			final int length = 10;
			final QuickSort quickSort = new QuickSort(randomData(length));
			System.out.println(quickSort);
			quickSort.sort();
			System.out.println(quickSort);
			System.out.println("***");
		}
	}

	private static int pickPivot(final int a, final int b) {
		return a + 0 * (int) ((b - a + 1) * Math.random());
	}

	private static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int rnd = (int) ((i + 1) * Math.random());
			data[i] = data[rnd];
			data[rnd] = i;
		}
		return data;
	}

	public void sort() {
		sort(0, data.length - 1);
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	private int partition(final int p, final int a, final int b) {
		swap(p, a);
		int i = a + 1;
		int j = b;

		for (;;) {
			while (i < j && data[i] < data[a])
				i++;
			if (i == j)
				break;
			while (i < j && data[j] > data[a])
				j--;
			if (i == j)
				break;
			swap(i, j);
		}
		swap(a, i - 1);
		return i - 1;
	}

	private void sort(final int a, final int b) {
		if (a >= b)
			return;

		if (b - a == 1) {
			if (data[a] > data[b])
				swap(a, b);
			return;
		}

		final int p = pickPivot(a, b);
		final int i = partition(p, a, b);
		sort(a, i);
		sort(i + 1, b);
	}

	private void swap(final int i, final int j) {
		if (i != j) {
			final int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

}
