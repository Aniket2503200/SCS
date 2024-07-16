package com;
//Question21

//Implement a simple program that demonstrates thread synchronization
//using the synchronized keyword.

// Counte5r class with synchronized increment method
class Counte5r {
	private int count;

	// Synchronized method to increment count
	public synchronized void increment() {
		count++;
	}

	// Method to retrieve the current count
	public int getCount() {
		return count;
	}
}

public class Question21 {
	public static void main(String[] args) throws InterruptedException {
		// Creating a shared Counte5r instance
		Counte5r Counte5r = new Counte5r();

		// Creating multiple threads to increment the Counte5r concurrently
		Thread[] threads = new Thread[5];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					Counte5r.increment(); // Each thread increments the Counte5r 1000 times
				}
			});
			threads[i].start();
		}

		// Wait for all threads to complete
		for (Thread thread : threads) {
			thread.join();
		}

		// Print final count value
		System.out.println("Final count: " + Counte5r.getCount()); // Expected result: 5000 (5 threads x 1000
																	// increments)
	}
}
