package com.google.hashtable;

public class MattsHashTable {

	private final HashCell[] hashCells;
	private int size;

	public MattsHashTable() {
		hashCells = new HashCell[16];
		size = 0;
	}

	public Object get(final Object key) {
		final int hash = getHash(key);
		final HashCell hashCell = hashCells[hash];
		if (hashCell == null)
			return null;
		return hashCell.getValue();
	}

	public void put(final Object key, final Object value) {
		final int hash = getHash(key);
		put(key, hash, value);
	}

	public Object remove(final Object key) {
		final int hash = getHash(key);
		return remove(key, hash);
	}

	private int getHash(final Object key) {
		return key == null ? 0 : key.hashCode() % hashCells.length;
	}

	private void put(final Object key, final int hash, final Object value) {
		HashCell hashCell = hashCells[hash];
		
		if (hashCell == null) {
			hashCell = new HashCell(key, value);
			size++;
		} else if (hashCell.isKey(key)) {
			hashCell.setValue(value);
		} else {
			while (hashCell.hasNext()) {
				HashCell next = hashCell.getNext();
				if (next.isKey(key)) {
					hashCell.setNext(next.getNext());
				}
				hashCell = next;
			}
		}
		hashCells[hash] = hashCell;
	}

	private Object remove(final Object key, final int hash) {
		HashCell hashCell = hashCells[hash];
		if (hashCell == null)
			return null;

		if (hashCell.isKey(key)) {
			hashCells[hash] = hashCell.getNext();
			size--;
			return hashCell.getValue();
		}
		
		while (hashCell.hasNext()) {
			HashCell next = hashCell.getNext();
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
