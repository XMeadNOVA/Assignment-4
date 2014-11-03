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
		
	/** Used by remove. */
	private boolean found;
	
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
	
	public void balance() {
		resetTraversalQueue(Order.INORDER);
		Queue<T> build = getTraversalQueue();
		root = new BSTNode();
		for (T e : build) {
			insert(e);
		}
	}
	
	public void insert(T element) {
		root.insert(element);
	}
	
	public boolean remove(T element) {
		root = recRemove(element, root);
		return found;
	}
	
	private BSTNode<T> recRemove(T element, BSTNode<T> tree) {
		if (tree == null) {
			found = false;
		}
		else if (element.compareTo(tree.getValue()) > 0) {
			tree.setLeft(recRemove(element, tree.getLeft()));
		}
		else if (element.compareTo(tree.getValue()) < 0) {
			tree.setRight(recRemove(element, tree.getRight()));
		}
		else {
			tree = removeNode(tree);
			found = true;
		}
		return tree;
	}
	
	private BSTNode<T> removeNode(BSTNode<T> tree) {
		T data;
		if (tree.getLeft() == null) {
			return tree.getRight();
		}
		else if (tree.getRight() == null) {
			return tree.getLeft();
		}
		else {
			data = getPredecessor(tree.getLeft());
			tree.setValue(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return traversalQueue.iterator();
	}
}
