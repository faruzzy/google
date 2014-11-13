package com.google.sort;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(final int[] data) {
		super(data, "InsertionSort");
	}

	@Override
	public void sort() {
		for (int i = 0; i < length - 1; ++i) {
			int min = i;
			for (int j = i + 1; j < length; ++j)
				if (data[min] > data[j])
					min = j;
			swap(i, min);
		}

	}

}
