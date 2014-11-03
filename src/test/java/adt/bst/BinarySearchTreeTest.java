/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package adt.bst;

import java.util.Iterator;
import java.util.Queue;
import junit.framework.TestCase;

/**
 *
 * @author amm28964
 */
public class BinarySearchTreeTest extends TestCase {
	
	public BinarySearchTreeTest(String testName) {
		super(testName);
	}

	/**
	 * Test of getRoot method, of class BinarySearchTree.
	 */
	public void testGetRoot() {
		System.out.println("getRoot");
		BinarySearchTree<String> instance = new BinarySearchTree();
		instance.insert("foo");
		BSTNode<String> expResult = new BSTNode<String>("foo");
		BSTNode result = instance.getRoot();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getOrder method, of class BinarySearchTree.
	 */
	public void testGetOrder() {
		System.out.println("getOrder");
		BinarySearchTree instance = new BinarySearchTree();
		Order expResult = Order.INORDER;
		Order result = instance.getOrder();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTraversalQueue method, of class BinarySearchTree.
	 */
	public void testGetTraversalQueue() {
		System.out.println("getTraversalQueue");
		BinarySearchTree<String> instance = new BinarySearchTree<String>();
		
		String[] preorderLetters = {"H","D","B","A","C","F","E","G","L","J","I","K","N","M","O"}; 
		String[] inorderLetters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
		String[] postorderLetters = {"A","C","B","E","G","F","D","I","K","J","M","O","N","L","H"};
		
		for (String str : preorderLetters) {
			instance.insert(str);
		}
		
		// Test Preorder
		Queue<String> expResult = new Queue<String>(preorderLetters);
		Queue<String> result = instance.getTraversalQueue();
		assertEquals(expResult, result);
		
		// Test Inorder
		
		// Test Postorder
		
	}

	/**
	 * Test of resetTraversalQueue method, of class BinarySearchTree.
	 */
	public void testResetTraversalQueue() {
		System.out.println("resetTraversalQueue");
		Order order = null;
		BinarySearchTree instance = new BinarySearchTree();
		instance.resetTraversalQueue(order);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of insert method, of class BinarySearchTree.
	 */
	public void testInsert() {
		System.out.println("insert");
		Object element = null;
		BinarySearchTree instance = new BinarySearchTree();
		instance.insert(element);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of iterator method, of class BinarySearchTree.
	 */
	public void testIterator() {
		System.out.println("iterator");
		BinarySearchTree instance = new BinarySearchTree();
		Iterator expResult = null;
		Iterator result = instance.iterator();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
