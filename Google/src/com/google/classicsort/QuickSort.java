package com.google.classicsort;

public class QuickSort implements SortingAlgorithm {

	private int[] data;

	private static int choosePivot(final int left, final int right) {
		return left + (int) ((right - left + 1) * Math.random());
	}

	public int partition(final int left, final int right, final int pivot) {
		final int value = data[pivot];
		swap(pivot, right);

		int index = left;
		for (int i = left; i < right; ++i)
			if (data[i] < value)
				swap(i, index++);
		swap(index, right);

		return index;
	}

	@Override
	public int[] sort(@SuppressWarnings("hiding") final int... data) {
		this.data = data;
		sort(0, data.length - 1);
		return data;
	}

	private void sort(final int left, final int right) {
		if (right - left < 1)
			return;
		
		if (left + 1 == right) {
			if (data[right] < data[left])
				swap(left, right);
			return;
		}

		final int pivot = choosePivot(left, right);
		final int index = partition(left, right, pivot);

		sort(left, index - 1);
		sort(index + 1, right);
	}

	private void swap(final int i, final int j) {
		if (i != j) {
			final int t = data[i];
			data[i] = data[j];
			data[j] = t;
		}
	}

}
