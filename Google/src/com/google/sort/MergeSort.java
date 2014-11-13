package com.google.sort;

import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {

	public MergeSort(final int[] data) {
		super(data, "MergeSort");
	}

	private static int[] merge(final int[] left, final int[] right) {
		final int[] merged = new int[left.length + right.length];
		int l = 0;
		int r = 0;
		for (int i = 0; i < merged.length; ++i)
			if (r == right.length || l < left.length && left[l] < right[r])
				merged[i] = left[l++];
			else
				merged[i] = right[r++];
		return merged;
	}

	private static int[] sort(final int[] copy) {
		if (copy.length < 2)
			return copy;
		if (copy.length == 2) {
			if (copy[0] <= copy[1])
				return copy;
			return new int[] { copy[1], copy[0] };
		}

		final int halfLen = copy.length / 2;
		final int[] left = sort(Arrays.copyOfRange(copy, 0, halfLen));
		final int[] right = sort(Arrays.copyOfRange(copy, halfLen, copy.length));
		return merge(left, right);
	}

	@Override
	public void sort() {
		data = sort(data);
	}

}
