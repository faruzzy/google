package com.google.sorting;

public class TestSorting {

	public static boolean isSorted(final int[] data) {
		for (int i = 1; i < data.length; ++i)
			if (data[i - 1] > data[i])
				return false;
		return true;
	}

	public static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
		}
		return data;
	}

}
