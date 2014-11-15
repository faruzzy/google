package com.google.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(final String... args) {
		final int length = 30;
		final int[] data = TestSorting.randomData(length);
		System.out.println(Arrays.toString(data));
		mergeSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	public static void mergeSort(final int[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	private static void merge(final int[] data, final int left, final int mid, final int right) {
		final int[] aux = new int[right - left + 1];
		int l = left;
		int r = mid + 1;
		for (int i = 0; i < aux.length; ++i)
			if (r > right || l <= mid && data[l] < data[r]) {
				aux[i] = data[l];
				l++;
			} else {
				aux[i] = data[r];
				r++;
			}
		for (int i = 0; i < aux.length; ++i)
			data[left + i] = aux[i];
	}

	private static void mergeSort(final int[] data, final int left, final int right) {
		if (right - left < 1)
			return;
		if (right == left + 1) {
			if (data[left] > data[right]) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
			return;
		}

		final int mid = left + (right - left) / 2;

		mergeSort(data, left, mid);
		mergeSort(data, mid + 1, right);

		merge(data, left, mid, right);
	}

}
