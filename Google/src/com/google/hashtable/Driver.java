package com.google.hashtable;

public class Driver {

	public static void main(final String... args) {
		final MattsHashTable hashTable = new MattsHashTable();
		hashTable.put("hello", "world");
		hashTable.put(14, "bye");
		hashTable.put(14, "two");

		System.out.println(hashTable.get("hello"));
		System.out.println(hashTable.get(14));
	}

}
