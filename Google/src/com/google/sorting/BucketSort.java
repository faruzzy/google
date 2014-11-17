package com.google.sorting;

import java.util.Arrays;

import com.google.datastructures.GenericQueue;

public class BucketSort {

	public static void bucketSort(final String[] data) {
		final int length = maxLength(data);
		final int min = minChar(data);
		final int max = maxChar(data);
		@SuppressWarnings({ "unchecked" })
		final GenericQueue<String>[] buckets = new GenericQueue[2 + max - min];
		for (int i = 0; i < buckets.length; ++i)
			buckets[i] = new GenericQueue<>();
		for (int i = length - 1; i > -1; --i) {
			for (final String string : data)
				if (string.length() <= i)
					buckets[0].enqueue(string);
				else
					buckets[1 + string.charAt(i) - min].enqueue(string);
			int pos = 0;
			for (final GenericQueue<String> bucket : buckets) {
				while (!bucket.isEmpty())
					data[pos++] = bucket.dequeue();
				bucket.clear();
			}
		}
	}

	public static void main(final String... args) {
		final String[] data = { "Hello", "There", "world", "Aaa", "BCD", "E", "Yes", "e", "103", "nine" };
		System.out.println(Arrays.toString(data));
		bucketSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(TestSorting.isSorted(data));
	}

	private static char maxChar(final String[] data) {
		char max = Character.MIN_VALUE;
		for (final String string : data)
			for (final char c : string.toCharArray())
				if (c > max)
					max = c;
		return max;
	}

	private static int maxLength(final String[] data) {
		int len = 0;
		for (final String string : data)
			if (string.length() > len)
				len = string.length();
		return len;
	}

	private static char minChar(final String[] data) {
		char min = Character.MAX_VALUE;
		for (final String string : data)
			for (final char c : string.toCharArray())
				if (c < min)
					min = c;
		return min;
	}

}
