package com.google.sort;

public class HeapSort extends SortingAlgorithm {

	public HeapSort(final int[] data) {
		super(data, "HeapSort");
	}

	@Override
	public void sort() {
		for (int i = 1; i < length; ++i)
			bubbleUp(i);
		for (int i = length - 1; i > 0; --i) {
			swap(0, i);
			bubbleDown(i - 1);
		}
	}

	private void bubbleDown(final int end) {
		int index = 0;
		for (;;) {
			final int left = 2 * index + 1;
			if (left > end)
				break;
			final int right = 2 * index + 2;
			final int max = right <= end && data[right] > data[left] ? right : left;
			if (data[max] > data[index]) {
				swap(index, max);
				index = max;
			} else
				break;
		}
	}

	private void bubbleUp(final int start) {
		int index = start;
		for (;;) {
			final int parent = (index - 1) / 2;
			if (data[parent] < data[index]) {
				swap(index, parent);
				index = parent;
			} else
				break;
		}
	}

}
