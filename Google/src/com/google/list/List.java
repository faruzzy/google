package com.google.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<T> implements Iterable<T> {

	private final int initialCapacity;
	private T[] data;
	private int size;

	public List() {
		this(0, 16);
	}

	public List(final int initialSize) {
		this(initialSize, initialSize);
	}

	@SuppressWarnings("unchecked")
	public List(final int initialSize, final int initialCapacity) {
		this.initialCapacity = initialCapacity;

		size = min(initialCapacity, initialSize);
		data = (T[]) new Object[initialCapacity];
	}

	private static int min(final int a, final int b) {
		return a < b ? a : b;
	}

	public void append(final T value) {
		data[size++] = value;
		
		if (size == data.length)
			resizeData(2 * size);
	}

	public T get(final int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		return data[index];
	}

	public int getSize() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index;
			@Override
			public boolean hasNext() {
				return index < getSize();
			}

			@Override
			public T next() {
				if (index == getSize())
					throw new NoSuchElementException();
				return get(index++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String... args) {
		List<String> list = new List<>();
		for (int i = 0; i < 30; ++i)
			list.append(Integer.toString(i));
		
		for (String s : list)
			System.out.println(s);
	}

	public void set(final T value, final int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		data[index] = value;
	}

	private void resizeData(final int capacity) {
		if (capacity >= initialCapacity) {
			@SuppressWarnings("unchecked")
			final T[] newData = (T[]) new Object[capacity];
			for (int i = 0; i < size; ++i)
				newData[i] = data[i];
			data = newData;
		}
	}

}
