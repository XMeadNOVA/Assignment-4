/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.bst;

import java.util.Iterator;
import adt.queue.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	private BSTNode<T> root;
	private Order order;
	private Queue<T> traversalQueue;
	
	public BinarySearchTree() {
		this.root = new BSTNode<T>(null);
		traversalQueue = new Queue<T>();
		resetTraversalQueue(Order.INORDER);
	}
	
	public BSTNode<T> getRoot() {
		return root;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Queue<T> getTraversalQueue() {
		return traversalQueue;
	}
		
	public void resetTraversalQueue(Order order) {
		this.order = order;
		traversalQueue = new Queue<T>();
		if (order == Order.PREORDER) {
			preorder(root);
		}
		else if (order == Order.INORDER) {
			inorder(root);
		}
		else {
			postorder(root);
		}
	}
	
	private void preorder(BSTNode<T> node) {
		if (node != null) {
			traversalQueue.enqueue(node.getValue());
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	private void inorder(BSTNode<T> node) {
		if (node != null) {
			inorder(node.getLeft());
			traversalQueue.enqueue(node.getValue());
			inorder(node.getRight());
		}
	}
	
	private void postorder(BSTNode<T> node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			traversalQueue.enqueue(node.getValue());
		}
	}
	
	public void insert(T element) {
		root.insert(element);
	}
	
	@Override
	public Iterator<T> iterator() {
		return traversalQueue.iterator();
	}
}
