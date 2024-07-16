package com;

//Question18
//What is thread safety, and why is it important?
// Non-thread-safe Counter33
class Counter33 {
	private int count;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

// Thread-safe Counter33 using synchronization
class SynchronizedCounter33 {
	private int count;

	public synchronized void increment() {
		count++;
	}

	public synchronized int getCount() {
		return count;
	}
}

public class Question18 {
	public static void main(String[] args) throws InterruptedException {
		// Creating instances of Counter33s
		Counter33 Counter33 = new Counter33();
		SynchronizedCounter33 synchronizedCounter33 = new SynchronizedCounter33();

		// Creating multiple threads to increment the Counter33s concurrently
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					Counter33.increment(); // Unsafe increment
					synchronizedCounter33.increment(); // Safe increment
				}
			});
			threads[i].start();
		}

		// Wait for all threads to complete
		for (Thread thread : threads) {
			thread.join();
		}

		// Printing results
		System.out.println("Non-thread-safe Counter33 result: " + Counter33.getCount()); // Result may vary
		System.out.println("Thread-safe Counter33 result: " + synchronizedCounter33.getCount()); // Expected result:
																									// 10000
	}
}
