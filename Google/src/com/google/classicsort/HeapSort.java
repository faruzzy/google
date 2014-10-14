package com.google.classicsort;

public class HeapSort implements SortingAlgorithm {

	private int[] heap;

	@Override
	public int[] sort(final int... data) {
		heap = data;

		buildHeap();
		unBuildHeap();

		return data;
	}

	private void bubbleDown(final int index, final int length) {
		int curr = index;
		for (;;) {
			final int left = 2 * curr + 1;
			final int right = 2 * curr + 2;

			if (left >= length)
				return;
			final int max = right < length && heap[right] > heap[left] ? right : left;

			if (heap[curr] < heap[max]) {
				swap(curr, max);
				curr = max;
			} else
				break;
		}
	}

	private void bubbleUp(final int index) {
		int curr = index;
		while (curr > 0) {
			final int parent = (curr - 1) / 2;
			if (heap[curr] > heap[parent]) {
				swap(curr, parent);
				curr = parent;
			} else
				break;
		}
	}

	private void buildHeap() {
		final int length = heap.length;
		for (int i = 0; i < length; i++)
			bubbleUp(i);
	}

	private void swap(final int i, final int j) {
		final int t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

	private void unBuildHeap() {
		final int length = heap.length;
		for (int i = length - 1; i > 0; --i) {
			swap(0, i);
			bubbleDown(0, i);
		}
	}

}
