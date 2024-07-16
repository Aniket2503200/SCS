package com;

//Question15
//What is a deadlock, and how can it be avoided in a multi-threaded program?
public class Question15 {
	private static final Object resourceA = new Object();
	private static final Object resourceB = new Object();

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			synchronized (resourceA) {
				System.out.println("Thread 1: Holding resource A...");

				try {
					Thread.sleep(100); // Simulating some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Thread 1: Waiting for resource B...");
				synchronized (resourceB) {
					System.out.println("Thread 1: Holding resource A and B...");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (resourceB) {
				System.out.println("Thread 2: Holding resource B...");

				try {
					Thread.sleep(100); // Simulating some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Thread 2: Waiting for resource A...");
				synchronized (resourceA) {
					System.out.println("Thread 2: Holding resource A and B...");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
