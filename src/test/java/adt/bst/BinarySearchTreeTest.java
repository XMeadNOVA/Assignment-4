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
		
		System.out.println("A".compareTo("B") < 0);
		
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
}
