package com.google.map;

public class Map<K, V> {

	private static final int[] PRIMES;

	static {
		PRIMES = new int[] { 17, 37, 73, 149, 307, 613, 1237, 2447, 5021 };
	}

	// TODO: implement a map using hash table with quadratic probing

	private int capacity;

	private Node<K, V>[] data;
	private int size;

	@SuppressWarnings("unchecked")
	public Map() {
		capacity = 0;
		data = new Node[PRIMES[capacity]];
		size = 0;

	}

	public boolean exists(final K key) {
		final int hash = key.hashCode() % data.length;
		return data[hash] != null;
	}

	public V get(final K key) {
		final int hash = key.hashCode() % data.length;
		final V value = data[hash].getValue();
		return value;
	}

	public void put(final K key, final V value) {
		final int hash = key.hashCode() & data.length;
		final Node<K, V> node = new Node<>(key, value);
		if (data[hash] == null)
			++size;

		if (size == PRIMES[capacity])
			resizeData(capacity + 1);

		data[hash] = node;
	}

	@SuppressWarnings("unchecked")
	private void resizeData(final int newCapacity) {
		if (capacity < 0)
			return;

		data = new Node[PRIMES[newCapacity]];

		capacity = newCapacity;
	}

}
