package com.google.tree.arraybst;

public class ArrayBST {

	private int[] data;
	private int length;
	private int count;

	public ArrayBST() {
		makeEmpty();
	}

	public boolean contains(final int value) {
		return find(value, false) >= 0;
	}

	public int getMax() {
		return data[findMax()];
	}

	public int getMin() {
		return data[findMin()];
	}

	public void insert(final int value) {
		if (value < 1)
			return;

		final int index = find(value);
		if (index < 0)
			count++;
		put(value, index);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void makeEmpty() {
		length = 15;
		data = new int[length];
		count = 0;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		// final int levels = (int) (Math.log(length + 1) / Math.log(2) + 0.5);
		// final int width = 1 << levels - 1;

		for (int i = 0; i < length; ++i)
			builder.append(String.format("%02d  ", data[i]));

		return builder.toString();
	}

	private int find(final int value) {
		return find(value, true);
	}

	private int find(final int value, final boolean resize) {
		int index = 0;
		while (index < length) {
			if (data[index] == 0)
				return -index;
			if (data[index] == value)
				return index;
			if (data[index] < value)
				index = 2 * index + 2;
			else
				index = 2 * index + 1;
		}
		if (resize)
			resizeData(2 * length + 1);
		return -index;
	}

	private int findMax() {
		int index = 0;
		for (;;) {
			final int next = 2 * index + 2;
			if (next >= length || data[next] == 0)
				return index;
			index = next;
		}
	}

	private int findMin() {
		int index = 0;
		for (;;) {
			final int next = 2 * index + 1;
			if (next >= length || data[next] == 0)
				return index;
			index = next;
		}
	}

	private void put(final int value, final int index) {
		data[index < 0 ? -index : index] = value;
	}

	private void resizeData(final int newLength) {
		System.out.println("resizing to " + newLength);
		final int oldLength = length;
		final int[] oldData = data;

		length = newLength;
		data = new int[length];

		for (int i = 0; i < oldLength; ++i)
			data[i] = oldData[i];
	}

}
