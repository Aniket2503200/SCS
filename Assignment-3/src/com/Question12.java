package com;

//Question12
//Does setting a thread's priority guarantee the order of execution?
//Explain why or why not.

public class Question12 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 1 executing iteration " + i);
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 2 executing iteration " + i);
			}
		});

		// Setting priorities
		thread1.setPriority(Thread.MIN_PRIORITY); // Minimum priority
		thread2.setPriority(Thread.MAX_PRIORITY); // Maximum priority

		// Starting threads
		thread1.start();
		thread2.start();
	}
}
