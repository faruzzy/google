package com.google.hashtable;

public interface HashTable {

	public Object get(final Object key);

	public int getSize();

	public void put(final Object key, final Object value);

	public Object remove(final Object key);

}
