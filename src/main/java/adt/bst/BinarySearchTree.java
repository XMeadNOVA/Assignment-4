/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.bst;

import adt.queue.Queue;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	public int size() {
		return root.size();
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
	
	/** @return height of the ideal construction of this tree.*/
	public int optimalHeight() {
		int size = size();
		if (size == 0) {
			return 0;
		}
		return (int) (Math.log(size)/Math.log(2));
	}
	
	public int height() {
		return Math.max(findHeight(root.getLeft()), findHeight(root.getRight()));
	}
	
	private int findHeight(BSTNode<T> tree) {
		if (tree == null) {
			return 0;
		}
		int leftHeight = findHeight(tree.getLeft());
		int rightHeight = findHeight(tree.getRight());
		return Math.max(leftHeight, rightHeight) + 1;
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
		ArrayList<T> nodes = new ArrayList<T>(size());
		for (T e : build) {
			nodes.add(e);
		}
		root = new BSTNode();
		recBalance(0, nodes.size()-1, nodes);
	}
	
	private void recBalance(int low, int high, ArrayList<T> nodes) {
		if (low == high) {
			root.insert(nodes.get(low));
		}
		else if (low + 1 == high) {
			root.insert(nodes.get(low));
			root.insert(nodes.get(high));
		}
		else {
			int mid = (high + low)/2;
			root.insert(nodes.get(mid));
			recBalance(low, mid-1, nodes);
			recBalance(mid+1, high, nodes);
		}
	}
	
	/**
	 * Retrieves an element from the BST.
	 * @param query Element to be retrieved.
	 * @return If found, the element; otherwise returns null.
	 */
	public T get(T query) {
		return root.get(query);
	}
	
	/**
	 * Inserts an element into the BST.
	 * The tree does not necessarily remain balanced.
	 * @param element 
	 */
	public void insert(T element) {
		root.insert(element);
	}
	/**
	 * Searches for and removes a node, replacing the removed node with its
	 * logical predecessor.
	 * @param element value to be searched for
	 * @return true if the value is found and successfully removed; otherwise, false.
	 */
	public boolean remove(T element) {
		root = recRemove(element, root);
		return found;
	}
	
	/**
	 * Recursive method that directs the search for an element in a subtree.
	 * @param element value to be searched for
	 * @param tree subtree in which to search
	 * @return the altered subtree
	 */
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
	
	/**
	 * Removes a node and replaces it with its logical predecessor.
	 * @param tree node to be removed
	 * @return the altered subtree
	 */
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
	
	/**
	 * @param tree node whose rightmost child is sought
	 * @return the value of the rightmost node in the tree
	 */
	private T getPredecessor(BSTNode<T> tree) {
		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree.getValue();
	}
	
	@Override
	public Iterator<T> iterator() {
		return traversalQueue.iterator();
	}
}
