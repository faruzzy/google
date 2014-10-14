package com.google.sortstring;

public class SortString {

	private final char[] order;

	public SortString(String order) {
		this.order = order.toCharArray();
	}
	
	public String sort(String string) {
		StringBuilder builder = new StringBuilder();
		int[] count = new int[Character.MAX_VALUE + 1];
		for (char c : string.toCharArray()) {
			count[c]++;
		}
		for (char c : order) {
			for (int i = 0; i < count[c]; ++i)
				builder.append(c);
		}
		return builder.toString();
	}
	
}
