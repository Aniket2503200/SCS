package com;

//Question11
//How can you set the priority of a thread in Java? What are the
//possible priority levels?
public class Question11 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread 1 is running with priority: " + Thread.currentThread().getPriority());
		});

		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2 is running with priority: " + Thread.currentThread().getPriority());
		});

		// Setting priorities
		thread1.setPriority(Thread.MIN_PRIORITY); // Minimum priority
		thread2.setPriority(Thread.MAX_PRIORITY); // Maximum priority

		// Starting threads
		thread1.start();
		thread2.start();
	}
}
