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
package adt.queue;


import java.util.Iterator;
import adt.linked_list.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> implements QueueInterface<T>, Iterable<T> {
	
	private LinkedList<T> list;
	
	public Queue() {
		list = new LinkedList<T>();
	}

	public synchronized void enqueue(T element) {
		list.add(element);
	}
	
	public synchronized T dequeue() throws QueueUnderflowException {
		try {
			return list.removeFirst();
		} catch(NoSuchElementException nse) {
			throw new QueueUnderflowException();
		}
	}
	
	public synchronized boolean isEmpty() {
		return list.isEmpty();
	}
	
	public synchronized int size() {
		return list.size();
	}
	
	public synchronized Iterator<T> iterator() {
		return list.iterator();
	}
}

