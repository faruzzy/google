package com.google.classicsort;

import java.util.Arrays;

/**
 * Quick Sort
 *
 * @author Matthew Robertson
 */
public class QuickSort {

	private final int[] data;

	public QuickSort(final int... data) {
		this.data = data;
	}

	public static void main(final String... args) {
		final int length = 10;
		final int[] data = randomData(length);
		final QuickSort quickSort = new QuickSort(data);
		System.out.println(quickSort);
		quickSort.sort();
		System.out.println(quickSort);
	}

	private static int pickPivot(final int a, final int b) {
		return a + 0 * (int) ((b - a + 1) * Math.random());
	}

	private static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
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

	private int partition(final int a, final int b, final int p) {
		final int value = data[p];
		swap(p, a);

		int i = a + 1;
		int j = b;

		for (;;) {
			while (data[i] < value) {
				if (i == j) {
					System.out.println("i met j at " + i);
					return i;
				}
				i++;
			}
			while (data[j] > value) {
				if (i == j) {
					System.out.println("j met i at " + i);
					return i;
				}
				j--;
			}
			swap(i, j);
			System.out.println("swaped " + i + " and " + j + " to get " + toString() + " for pivot " + value);
		}
	}

	private void sort(final int a, final int b) {
		if (b - a < 2)
			return;

		final int p = pickPivot(a, b);
		final int i = partition(a, b, p);

		// sort(a, i - 1);
		// sort(i + 1, b);
	}

	private void swap(final int i, final int j) {
		final int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

}
