package com;

//Question5
//What is the difference between calling the start() method and calling
//the run() method directly on a thread object?
public class Question5 {
	public static void main(String[] args) {
		// Create an instance of MyThread1
		MyThread1 thread = new MyThread1();

		// Calling run() directly
		System.out.println("Calling run() directly:");
		thread.run(); // Executes run() in the main thread

		// Calling start()
		System.out.println("Calling start():");
		thread.start(); // Starts a new thread and executes run() in that thread
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " - Count: " + i);
			try {
				Thread.sleep(1000); // Sleep for a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
