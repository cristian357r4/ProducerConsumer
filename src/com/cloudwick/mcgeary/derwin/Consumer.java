package com.cloudwick.mcgeary.derwin;
import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
	private ArrayBlockingQueue queue;
	
	public Consumer(ArrayBlockingQueue q) {
		this.queue = q;
	}
	
	public void run() {

	    try {
	    for(String message = (String) queue.take(); !message.equals("DONE"); message = (String) queue.take()) {
			System.out.println(message);
		}
	    } catch (InterruptedException e){ System.out.println("Oh no! Interrupted");}
	}
}
