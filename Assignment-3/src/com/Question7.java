package com;
//Question7

//What is a race condition, and how can it be avoided using the
//synchronized keyword in Java?

public class Question7 {
	public static void main(String[] args) {
		Counter2 counter = new Counter2();

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
		System.out.println("Final Count (with synchronization): " + counter.getCount());
	}
}

class Counter2 {
	private int count;

	public synchronized void increment() {
		count++;
	}

	public synchronized int getCount() {
		return count;
	}
}
