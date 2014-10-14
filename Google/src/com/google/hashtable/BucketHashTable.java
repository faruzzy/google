package com.google.hashtable;

public class BucketHashTable implements HashTable {

	private Bucket[] hashCells;
	private int size;

	public BucketHashTable() {
		hashCells = new Bucket[16];
		size = 0;
	}

	@Override
	public Object get(final Object key) {
		final int hash = getHash(key);
		return get(key, hash);
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void put(final Object key, final Object value) {
		final int hash = getHash(key);
		put(key, hash, value);

		final int length = hashCells.length;
		if (size * 3 / 2 > length)
			resizeTable(length * 2);
	}

	@Override
	public Object remove(final Object key) {
		final int hash = getHash(key);
		return remove(key, hash);
	}

	public void resizeTable(final int newLength) {
		final Bucket[] oldHashCells = hashCells;
		size = 0;
		hashCells = new Bucket[newLength];
		for (Bucket hashCell : oldHashCells)
			while (hashCell != null) {
				put(hashCell.getKey(), hashCell.getValue());
				hashCell = hashCell.getNext();
			}
	}

	private Object get(final Object key, final int hash) {
		Bucket hashCell = hashCells[hash];
		if (hashCell == null)
			return null;
		if (hashCell.isKey(key))
			return hashCell.getValue();
		while (hashCell.hasNext()) {
			final Bucket next = hashCell.getNext();
			if (next.isKey(key))
				return next.getValue();
			hashCell = next;
		}
		return null;
	}

	private int getHash(final Object key) {
		return key == null ? 0 : key.hashCode() % hashCells.length;
	}

	private void put(final Object key, final int hash, final Object value) {
		Bucket hashCell = hashCells[hash];

		if (hashCell == null) {
			hashCell = new Bucket(key, value);
			size++;
		} else if (hashCell.isKey(key))
			hashCell.setValue(value);
		else {
			while (hashCell.hasNext()) {
				final Bucket next = hashCell.getNext();
				if (next.isKey(key)) {
					hashCell.setNext(next.getNext());
					size--;
					break;
				}
				hashCell = next;
			}
			hashCell = new Bucket(key, value);
			hashCell.setNext(hashCells[hash]);
			size++;
		}
		hashCells[hash] = hashCell;
	}

	private Object remove(final Object key, final int hash) {
		Bucket hashCell = hashCells[hash];
		if (hashCell == null)
			return null;

		if (hashCell.isKey(key)) {
			hashCells[hash] = hashCell.getNext();
			size--;
			return hashCell.getValue();
		}

		while (hashCell.hasNext()) {
			final Bucket next = hashCell.getNext();
			if (next.isKey(key)) {
				hashCell.setNext(next.getNext());
				size--;
				return next.getValue();
			}
			hashCell = next;
		}

		return null;
	}

}
