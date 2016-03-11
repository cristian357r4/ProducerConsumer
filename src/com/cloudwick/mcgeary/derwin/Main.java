

package com.cloudwick.mcgeary.derwin;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
	
	public static void main(String[] args) {
	    ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(10);		    
	    
		Producer p1 = new Producer(q);
		Producer p2 = new Producer(q);
		Thread c1 = new Thread(new Consumer(q));
		Thread c2 = new Thread(new Consumer(q));
		
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
