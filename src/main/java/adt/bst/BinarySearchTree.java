/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.bst;

import adt.bst.BSTNode;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	private BSTNode<T> root;
	
	public BinarySearchTree() {
		this.root = new BSTNode<T>();
	}
	
	@Override
	public Iterator<T> iterator() {
		
	}
	
	
}
