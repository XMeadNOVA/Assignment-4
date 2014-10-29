/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.bst;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	private BSTNode<T> root;
	
	public BinarySearchTree() {
		this.root = new BSTNode<T>();
	}
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator() {

			@Override
			public boolean hasNext() {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}

			@Override
			public Object next() {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}
			
		};
		return it;		
	}
	
	
}
