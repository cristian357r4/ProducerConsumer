package com.cloudwick.mcgeary.derwin;

public class Consumer implements Runnable {
	private MyQueue queue;
	
	public Consumer(MyQueue q) {
		this.queue = q;
	}
	
	public void run() {
		for(String message = queue.take(); !message.equals("DONE"); message = queue.take()) {
			System.out.println(message);
		}
	}
}
