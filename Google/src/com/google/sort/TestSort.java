package com.google.sort;

public class TestSort {

	public static boolean isSorted(final SortingAlgorithm sortingAlgorithm) {
		final int[] data = sortingAlgorithm.getData();
		for (int i = 0; i < data.length - 1; ++i)
			if (data[i + 1] < data[i])
				return false;
		return true;
	}

	public static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int rand = (int) ((i + 1) * Math.random());
			data[i] = data[rand];
			data[rand] = i;
		}
		return data;
	}

	public static boolean testRepeats() {
		final int[] data = { 0, 1, 2, 2, 2, 2, 5, 2, 9, 5, 6, 7, 8, 3, 3, 3, 3, 3, 3, 100, -4, 99 };
		for (final SortingAlgorithm sortingAlgorithm : instanceSortingAlgorithms(data)) {
			sortingAlgorithm.sort();
			if (!isSorted(sortingAlgorithm)) {
				System.out.println(sortingAlgorithm);
				return false;
			}
		}
		return true;
	}

	public static boolean testSorts() {
		for (int length = 1; length < 10240; length *= 2)
			for (int i = 0; i < 10; ++i) {
				length += i;
				final int[] data = randomData(length);
				for (final SortingAlgorithm sortingAlgorithm : instanceSortingAlgorithms(data)) {
					sortingAlgorithm.sort();
					if (!isSorted(sortingAlgorithm)) {
						System.out.println(sortingAlgorithm);
						return false;
					}
				}
			}
		return true;
	}

	private static int[] copy(final int[] data) {
		final int[] copy = new int[data.length];
		for (int i = 0; i < data.length; ++i)
			copy[i] = data[i];
		return copy;
	}

	private static SortingAlgorithm[] instanceSortingAlgorithms(final int[] data) {
		return new SortingAlgorithm[] { new InsertionSort(copy(data)), new QuickSort(copy(data)), new MergeSort(copy(data)),
			new HeapSort(copy(data)) };
	}

}
