package com;

//Question4
//Explain the purpose of the start(), run(), and join() methods in the
//context of Java threads.
public class Question4 {
	public static void main(String[] args) {
		ThreadExample thread1 = new ThreadExample("Thread-1");
		ThreadExample thread2 = new ThreadExample("Thread-2");

		System.out.println("Starting threads");
		thread1.start(); // This will start thread1 and call its run() method
		thread2.start(); // This will start thread2 and call its run() method

		try {
			// Wait for both threads to complete
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Both threads have finished execution");
	}
}

class ThreadExample extends Thread {
	private String threadName;

	ThreadExample(String name) {
		this.threadName = name;
	}

	@Override
	public void run() {
		System.out.println(threadName + " is running");
		for (int i = 0; i < 5; i++) {
			System.out.println(threadName + " - Count: " + i);
			try {
				Thread.sleep(1000); // Sleep for a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(threadName + " has finished running");
	}
}