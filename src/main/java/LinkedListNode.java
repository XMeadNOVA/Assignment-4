/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amm28964
 */
public class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> link;
	
	public LinkedListNode(T value) {
		this.value = value;
		this.link = null;
	}
	
	public LinkedListNode<T> getLink() {
		return link;
	}
}
