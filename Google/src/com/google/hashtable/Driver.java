package com.google.hashtable;

public class Driver {

	public static void main(final String... args) {
		TestHashTable.test(new BucketHashTable());
		System.out.println("***");
		TestHashTable.test(new ArrayHashTable());
	}

}
