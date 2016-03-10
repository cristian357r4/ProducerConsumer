package com.cloudwick.mcgeary.derwin;

public class Main {
	
	public static void main(String[] args) {
		Box b = new Box();
		Producer p1 = new Producer(b);
		Producer p2 = new Producer(b);
		Consumer c1 = new Consumer(b);
		Consumer c2 = new Consumer(b);
		
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		
		try {
			c2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished successfully!");
	}
	
}
