package com.google.sort;

public class QuickSort extends SortingAlgorithm {

	public QuickSort(final int[] data) {
		super(data, "QuickSort");
	}

	private static int pickPivot(final int start, final int end) {
		return start + (int) (Math.random() * (end - start + 1));
	}

	@Override
	public void sort() {
		sort(0, length - 1);
	}

	private void insertionSort(final int start, final int end) {
		for (int i = start; i < end; ++i) {
			int min = i;
			for (int j = i + 1; j <= end; ++j)
				if (data[j] < data[min])
					min = j;
			swap(i, min);
		}
	}

	private int partition(final int start, final int end, final int pivot) {
		final int value = data[pivot];
		swap(pivot, start);
		int i = start + 1;
		int j = end;
		for (;;) {
			while (data[i] <= value && i < end)
				++i;
			while (data[j] > value)
				--j;
			if (i >= j)
				break;
			swap(i, j);
		}
		swap(start, j);
		return j;
	}

	private void sort(final int start, final int end) {
		if (end - start < 10)
			insertionSort(start, end);
		else {
			final int pivot = pickPivot(start, end);
			final int index = partition(start, end, pivot);
			sort(start, index - 1);
			sort(index + 1, end);
		}
	}

}
