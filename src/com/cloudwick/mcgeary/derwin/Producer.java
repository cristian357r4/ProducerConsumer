package com.cloudwick.mcgeary.derwin;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread {
	private ArrayBlockingQueue queue;
	
	public Producer(ArrayBlockingQueue queue) {
		this.queue = queue;
	}
	
	public void run() {
		String[] msgs = {"Shall", "I", "compare", "thee", "to", "a", "Summer's", "Day?",
						"Thou", "art", "more","lovely","and","more","temperate"}; // >10 words to test our queue out
		
		for(String message : msgs) {
		    try {
			queue.put(message);
		    } catch (InterruptedException e) {}
		}

		try {
		    queue.put("DONE");
		} catch (InterruptedException e) {}
	}
}
