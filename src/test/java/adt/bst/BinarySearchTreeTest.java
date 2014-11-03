/*
 * Copyright (C) 2014 amm28964
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
