package com.cloudwick.mcgeary.derwin;

// This is intended to implement a shared, thread-friendly, LIFO object
// I referenced http://www.cs.bu.edu/teaching/c/queue/array/types.html

public class MyQueue {
	private String[] messages;
	private int count;
	private int front;
	
	public MyQueue(int size) {
		this.messages = new String[size];
		this.count = 0;
		this.front = 0;
	}
	
	public boolean isEmpty() {
		return (count==0);
	}
	
	public boolean isFull() {
		return (count==messages.length);
	}
	
	public synchronized String take() {
		while(!(count>0)) { // if we're empty, wait
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		count--; // one less queue item
		front++; // the front is now the next array slot
		front = front % messages.length; 
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
