package com;

//Question6
//Why is thread synchronization necessary in a multi-threaded environment?
public class Question6 {
	public static void main(String[] args) {
		Counter counter = new Counter();

		// Create and start multiple threads
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		// Start threads
		thread1.start();
		thread2.start();

		// Wait for threads to complete
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Expected count: 2000
		System.out.println("Final Count (without synchronization): " + counter.getCount());
	}
}

class Counter {
	private int count;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
