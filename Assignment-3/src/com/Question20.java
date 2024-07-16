package com;

//Question20
//Modify a given program to use the Runnable interface instead of
//extending the Thread class.

// Implementing Runnable interface
public class Question20 {

	// Runnable task implementation
	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Runnable task is running...");
		}
	}

	public static void main(String[] args) {
		// Creating an instance of MyRunnable
		MyRunnable myRunnable = new MyRunnable();

		// Creating a Thread object with MyRunnable instance
		Thread thread = new Thread(myRunnable);

		// Starting the thread
		thread.start();
	}
}
