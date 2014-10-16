package com.google.graph;

public interface Graph<T> {

	public void addEdge(int i, int j);

	public int addNode(T node);

	public boolean edgeExists(int i, int j);

	public int getM();

	public int getN();

	public T getNode(int i);

	public boolean isDirected();

	public void removeEdge(int i, int j);

	public void removeNode(int i);
	
	public int[] getChildren(int i);

}
