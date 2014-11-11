/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package adt.bst;

import adt.queue.Queue;
import junit.framework.TestCase;

/**
 *
 * @author amm28964
 */
public class BinarySearchTreeTest extends TestCase {

	/**
	 * Test of getTraversalQueue method, of class BinarySearchTree.
	 */
	public void testGetTraversalQueue() {
		System.out.println("getTraversalQueue");
		BinarySearchTree<String> instance = new BinarySearchTree<String>();
		
		String[] preorderLetters =  {"H","D","B","A","C","F","E","G","L","J","I","K","N","M","O"}; 
		String[] inorderLetters =   {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
		String[] postorderLetters = {"A","C","B","E","G","F","D","I","K","J","M","O","N","L","H"};
		
		for (String str : preorderLetters) {
			instance.insert(str);
		}
		
		// Test Preorder
		instance.resetTraversalQueue(Order.PREORDER);
		Queue<String> expResult = new Queue<String>(preorderLetters);
		Queue<String> result = instance.getTraversalQueue();
		assertEquals(expResult, result);
		
		// Test Inorder
		instance.resetTraversalQueue(Order.INORDER);
		expResult = new Queue<String>(inorderLetters);
		result = instance.getTraversalQueue();
		assertEquals(expResult, result);
		
		// Test Postorder
		instance.resetTraversalQueue(Order.POSTORDER);
		expResult = new Queue<String>(postorderLetters);
		result = instance.getTraversalQueue();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of height and optimalHeight methods, of class BinarySearchTree
	 */
	public void testHeight() {
		System.out.println("height");
		String[] letters = {"A","C","B","E","G","F","D","I","K","J","M","O","N","L","H"};
		
		// Initialize BST
		BinarySearchTree<String> instance = new BinarySearchTree<String>();
		for (String s : letters) {
			instance.insert(s);
		}
		
		// Test height method
		int expResult = 8;
		int result = instance.height();
		assertEquals("Tree height should be 8", expResult, result);
		
		// Test optimal height method
		expResult = 3;
		result = instance.optimalHeight();
		assertEquals("Optimal height should be three", expResult, result);
	}
}
