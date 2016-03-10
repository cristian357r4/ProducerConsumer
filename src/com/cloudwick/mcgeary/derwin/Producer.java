package com.cloudwick.mcgeary.derwin;

public class Producer extends Thread {
	private MyQueue queue;
	
	public Producer(MyQueue queue) {
		this.queue = queue;
	}
	
	public void run() {
		String[] msgs = {"Shall", "I", "compare", "thee", "to", "a", "Summer's", "Day?",
						"Thou", "art", "more","lovely","and","more","temperate"}; // >10 words to test our queue out
		
		for(String message : msgs) {
			queue.put(message);
		}
		
		queue.put("DONE");
	}
}
