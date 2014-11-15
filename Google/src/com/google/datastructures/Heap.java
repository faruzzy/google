package com.google.datastructures;

public class Heap {

	private static final int INITIAL_CAPACITY = 16;

	private int[] data;
	private int size;

	public Heap() {
		data = new int[INITIAL_CAPACITY];
		size = 0;
	}

	public static void main(final String... args) {
		final Heap heap = new Heap();
		for (int i = 0; i < 300; ++i)
			heap.insert(i);
		for (int i = 299; i > -1; --i)
			if (heap.isEmpty() || heap.deleteMax() != i)
				System.out.println("OOPS " + i);
		System.out.println(heap.isEmpty());
	}

	public void clear() {
		data = new int[INITIAL_CAPACITY];
		size = 0;
	}

	public int deleteMax() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		final int value = data[0];
		--size;
		swap(0, size);
		bubbleDown(0);

		if (size < data.length / 4)
			resizeData(2 * data.length / 2);

		return value;
	}

	public void insert(final int value) {
		data[size] = value;
		bubbleUp(size);
		++size;
		if (size == data.length)
			resizeData(2 * data.length);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peekMax() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		return data[0];
	}

	private void bubbleDown(final int index) {
		int parent = index;
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;
		int child = right < size && data[right] > data[left] ? right : left;
		while (child < size && data[child] > data[parent]) {
			swap(parent, child);
			parent = child;
			left = 2 * parent + 1;
			right = 2 * parent + 2;
			child = right < size && data[right] > data[left] ? right : left;
		}
	}

	private void bubbleUp(final int index) {
		int child = index;
		int parent = (child - 1) / 2;
		while (data[child] > data[parent]) {
			swap(child, parent);
			child = parent;
			parent = (child - 1) / 2;
		}
	}

	private void resizeData(final int capacity) {
		if (capacity < INITIAL_CAPACITY)
			return;

		final int[] newData = new int[capacity];
		for (int i = 0; i < size; ++i)
			newData[i] = data[i];
		data = newData;
	}

	private void swap(final int i, final int j) {
		if (i != j) {
			final int t = data[i];
			data[i] = data[j];
			data[j] = t;
		}
	}

}
