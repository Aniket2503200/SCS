package com;

//Question1
//Example of Creating a Thread Using the Thread Class and Runnable Interface

public class Question1 {
	public static void main(String[] args) {
		// Using Thread class
		Thread thread1 = new MyThread();
		thread1.start();

		// Using Runnable interface
		Runnable runnable = new MyRunnable();
		Thread thread2 = new Thread(runnable);
		thread2.start();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread using Thread class is running");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread using Runnable interface is running");
	}
}
