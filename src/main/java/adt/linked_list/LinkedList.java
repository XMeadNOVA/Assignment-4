/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.linked_list;

import adt.linked_list.LLNode;

public class LinkedList<T> {
	private LLNode<T> head;
	private LLNode<T> foot;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.foot = null;
		this.size = 0;
	}
	
	public LLNode<T> getHead() {
		return head;
	}
	
	public int size() {
		return size;
	}
	
	public void add(T value) {
		this.add(new LLNode<T>(value));
	}
	
	public void add(LLNode<T> node) {
		if (size == 0) {
			head = node;
		}
		else if (size == 1) {
			head.setLink(node);
			foot = node;
		}
		else {
			foot.setLink(node);
			foot = node;
		}
		size++;
	}
	
	public void addToFront(T value) {
		this.addToFront(new LLNode<T>(value));
		size++;
	}
	
	public void addToFront(LLNode<T> node) {
		LLNode<T> other = head.getLink();
		head = node;
		head.setLink(other);
		size++;
	}
	
	public T get(T query) {
		LLNode<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.getValue().equals(query)) {
				return currentNode.getValue();
			}
			currentNode = currentNode.getLink();
		}
		return null;
	}
		
	/**
	 * Removes the first node in the LinkedList equal to target.
	 * @param target Value of the node to be searched for and deleted.
	 * @return Returns the value of the deleted node if the node is found. Otherwise, returns null.
	 */
	public T remove(T target) {
		LLNode<T> lastNode = null;
		LLNode<T> currentNode = head;
		// traverse to end
		while (currentNode != null) {
			T value = currentNode.getValue();
			if (value.equals(target)) {
				// Remove node from list
				if (currentNode.equals(head)) {
					head = head.getLink();
				}
				else if (currentNode.equals(foot)) {
					foot = lastNode;
					foot.setLink(null);
				}
				else {
					lastNode.setLink(currentNode.getLink());
				}
				size--;
				return value;
			}
			// "increment"
			lastNode = currentNode;
			currentNode = currentNode.getLink();
		}
		return null;
	}
	
	public T removeFirst() {
		T value = head.getValue();
		head = head.getLink();
		size--;
		return value;
	}
	
	public boolean isEmpty() {
		return size > 0;
	}
	
	@Override
	public String toString() {
		String result = "";
		LLNode<T> currentNode = head;
		while (currentNode != null) {
			result += currentNode.toString();
			result += "\n";
		}
		return result;
	}
}
