package com.google.classicsort;

import java.util.Arrays;

/**
 * Merge Sort (Not in place...)
 *
 * @author Matthew Robertson
 */
public class MergeSort {

	public static void main(final String... args) {
		final int length = 10;
		for (int i = 0; i < 100; ++i) {
			final int[] data = randomData(length);
			System.out.println(Arrays.toString(data));
			final int[] data2 = sort(data);
			System.out.println(Arrays.toString(data2));
			System.out.println("***");
		}
	}

	public static int[] sort(final int... data) {
		if (data.length <= 1)
			return data.clone();
		if (data.length == 2) {
			if (data[0] > data[1])
				return new int[] { data[1], data[0] };
			return data.clone();
		}
		final int mid = data.length / 2;
		final int[] a = sort(Arrays.copyOf(data, mid));
		final int[] b = sort(Arrays.copyOfRange(data, mid, data.length));
		return merge(a, b);
	}

	private static int[] merge(final int[] a, final int[] b) {
		final int length = a.length + b.length;
		final int[] data = new int[length];
		int i = 0;
		int j = 0;
		while (i + j < length)
			if (i < a.length && (j == b.length || a[i] < b[j])) {
				data[i + j] = a[i];
				i++;
			} else {
				data[i + j] = b[j];
				j++;
			}
		return data;
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

}
