package com.google.classicsort;

public class TestSortingAlgorithm {

	public static boolean test(final SortingAlgorithm sortingAlgorithm) {
		for (int length = 1; length < 4000000; length += (int) (Math.random() * (2 + length / 2 * 3)))
			if (testSort(sortingAlgorithm, length))
				System.out.printf("Test length %d is ok!\n", length);
			else {
				System.out.printf("Test length %d FAILED!\n", length);
				System.out.println("Failed!");
				return false;
			}
		System.out.println("Done!");
		return true;
	}

	private static boolean isSorted(final int[] data, final int length) {
		for (int i = 0; i < length - 1; ++i)
			if (data[i] > data[i + 1])
				return false;
		return true;
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

	private static boolean testSort(final SortingAlgorithm sortingAlgorithm, final int length) {
		final int[] data = randomData(length);
		final int[] sorted = sortingAlgorithm.sort(data);
		return isSorted(sorted, length);
	}

}
