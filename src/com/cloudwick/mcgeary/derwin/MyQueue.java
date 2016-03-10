package com.cloudwick.mcgeary.derwin;

// This is intended to implement a shared, thread-friendly, LIFO object
// A British-style queue (Russian queues are actually doubly-linked lists)
// I referenced http://www.cs.bu.edu/teaching/c/queue/array/types.html

public class MyQueue {
	String[] messages;
	int count;
	int front;
	
	public MyQueue(int n) {
		this.messages = new String[n];
		this.count = 0;
		this.front = 0;
	}
	
	public synchronized String take() {
		while(!(count>0)) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		count--; // one less queue item
		front++; // the front is now the next array slot
		notifyAll(); // tell the world
		return messages[front]; // and the calling function
	}
	
	public void put(String newMessage) {
		synchronized(this) {
			while(!(count < messages.length)) { // i.e. we're full
				try { 
					wait(); 
				} catch (InterruptedException e) {}
			}
			
			count++;			
			int last = (front + count) % messages.length; // End of the circular queue
			this.messages[last] = newMessage;
			notifyAll();
			return;
		}
	}
	
	
	
}
