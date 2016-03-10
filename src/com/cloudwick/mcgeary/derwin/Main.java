package com.cloudwick.mcgeary.derwin;

public class Main {
	
	public static void main(String[] args) {
		MyQueue q = new MyQueue(10);		
		
		Producer p1 = new Producer(q);
		Producer p2 = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		
		try {		// Let these two finish before announcing the finish
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished successfully!");
	}
	
}
