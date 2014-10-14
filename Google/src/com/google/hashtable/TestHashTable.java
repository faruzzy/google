package com.google.hashtable;

public class TestHashTable {

	public static void test(final HashTable hashTable) {
		final int length = 30000;
		final int[] keys = randomData(length);
		final int[] values = randomData(length);

		for (int i = 0; i < length; ++i)
			hashTable.put(keys[i], values[i]);

		for (int i = 0; i < length; ++i) {
			Object object = hashTable.get(keys[i]);
			if (object == null) {
				System.out.println("null problem with " + i);
				System.exit(0);
				return;
			}
			final int value = (Integer) object;
			if (value != values[i]) {
				System.out.println("Problem with " + value + " (" + i + ")");
				return;
			}
		}

		System.out.println(hashTable.getSize());
		
		if (hashTable.remove(length + 3) != null)
				System.out.println("Oops removing non-existing object...");
		
		for (int i = 0; i < length; ++i) {
			hashTable.remove(i);
			if (hashTable.get(i) != null) {
				System.out.println("Oops with " + i);
				return;
			}
		}

		System.out.println(hashTable.getSize());
	}

	private static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
		}
		return data;
	}

}
