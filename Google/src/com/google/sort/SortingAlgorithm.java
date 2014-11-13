package com.google.sort;

import java.util.Arrays;

public abstract class SortingAlgorithm {

	protected int[] data;
	protected final int length;
	protected final String name;

	public SortingAlgorithm(final int[] data, final String name) {
		this.data = data;
		this.name = name;
		length = data.length;
	}

	public int[] getData() {
		return data;
	}

	public abstract void sort();

	@Override
	public String toString() {
		return name + " " + Arrays.toString(data);
	}

	protected void swap(final int i, final int j) {
		if (i != j) {
			final int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

}
