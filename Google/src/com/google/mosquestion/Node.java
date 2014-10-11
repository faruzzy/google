package com.google.mosquestion;

public class Node {

	private final int name;
	private String knownPath;
	private int knownLength;

	public Node(final int name) {
		this.name = name;
		knownPath = Integer.toString(name);
		knownLength = 0;
	}

	public void addKnownLength(final int addLength) {
		knownLength = 1 + addLength;
	}

	public void appendKnownPath(final String appendPath) {
		knownPath += "," + appendPath;
	}

	public int getKnownLength() {
		return knownLength;
	}

	public String getKnownPath() {
		return knownPath;
	}

	public int getName() {
		return name;
	}

	public boolean isExplored() {
		return knownLength > 0;
	}

	@Override
	public String toString() {
		return knownPath;
	}

}
