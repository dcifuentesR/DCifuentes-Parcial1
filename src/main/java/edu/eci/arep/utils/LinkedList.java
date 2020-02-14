package edu.eci.arep.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements List<T>,Iterable<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public boolean add(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null)
			tail = head = node;
		else {
			tail.setNextNode(node);
			tail = node;
		}
		size++;
		return true;
	}

	// return Head
	public Node<T> getHead() {
		return head;
	}

	// return Tail
	public Node<T> getTail() {
		return tail;
	}

	// return Iterator instance
	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
	
	class ListIterator<T> implements Iterator<T>{
		private Node<T> current;
		
		public ListIterator(LinkedList<T> list) {
			current=list.getHead();
		}

		public boolean hasNext() {
			return current !=null;
		}

		public T next() {
			T value =current.getValue();
			current = current.getNextNode();
			return value;
		}
		
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object o) {
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public java.util.ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.util.ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}