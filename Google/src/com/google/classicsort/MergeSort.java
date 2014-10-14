package com.google.classicsort;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

	@Override
	public int[] sort(final int... data) {
		final int length = data.length;
		if (length < 2)
			return data.clone();

		if (length == 2) {
			if (data[0] > data[1])
				return new int[] { data[1], data[0] };
			return data.clone();
		}

		final int mid = length / 2;
		final int[] left = sort(Arrays.copyOf(data, mid));
		final int[] right = sort(Arrays.copyOfRange(data, mid, length));

		final int[] merge = new int[length];
		int l = 0, r = 0;
		for (int i = 0; i < length; ++i)
			if (l < left.length && (r == right.length || left[l] < right[r]))
				merge[i] = left[l++];
			else
				merge[i] = right[r++];

		return merge;
	}

}
