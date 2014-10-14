package com.google.hashtable;

public class ArrayHashTable implements HashTable {

	private Cell[] table;
	private int size;

	public ArrayHashTable() {
		table = new Cell[16];
		size = 0;
	}

	@Override
	public Object get(final Object key) {
		final int length = table.length;
		final int hash = getHash(key);

		int offset = 0;
		while (offset < length) {
			final int index = (hash + offset) % length;
			final Cell cell = table[index];
			if (cell != null && cell.isKey(hash, key))
				return cell.getValue();

			offset = offset == 0 ? 1 : 2 * offset;
		}

		return null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void put(final Object key, final Object value) {
		final int hash = getHash(key);
		put(hash, key, value);

		final int length = table.length;
		if (size * 3 / 2 > length)
			resizeTable(2 * length);
	}

	@Override
	public Object remove(final Object key) {
		final int length = table.length;
		final int hash = getHash(key);

		int offset = 0;
		while (offset < length) {
			final int index = (hash + offset) % length;
			final Cell cell = table[index];
			if (cell != null && cell.isKey(hash, key)) {
				table[index] = null;
				size--;
				return cell.getValue();
			}

			offset = offset == 0 ? 1 : 2 * offset;
		}

		return null;
	}

	private int getHash(final Object key) {
		final int length = table.length;
		return key == null ? 0 : key.hashCode() % length;
	}

	private void put(final int hash, final Object key, final Object value) {
		final int length = table.length;
		final Cell cell = new Cell(hash, key, value);

		int offset = 0;
		while (offset < length) {
			final int index = (hash + offset) % length;
			if (table[index] == null) {
				table[index] = cell;
				size++;
				return;
			}
			if (table[index].isKey(hash, key)) {
				table[index] = cell;
				return;
			}

			offset = offset == 0 ? 1 : 2 * offset;
		}

		resizeTable(2 * length);
		put(hash, key, value);
	}

	private void resizeTable(final int newSize) {
		final Cell[] oldTable = table;
		table = new Cell[newSize];
		size = 0;
		for (final Cell cell : oldTable)
			if (cell != null)
				put(cell.getKey(), cell.getValue());
	}

}
