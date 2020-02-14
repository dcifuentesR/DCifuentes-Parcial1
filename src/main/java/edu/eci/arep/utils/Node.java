package edu.eci.arep.utils;

public class Node<T> {
	
	private Node<T> nextNode;
	private Node<T> prevNode;
	
	private T value;
	
	public Node(T value) {
		this.value=value;
	}
	
	public T getValue() {
		return value;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

}
