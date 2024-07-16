package com;

//Question2
//Describe the lifecycle of a thread in Java. What are the different
//states a thread can be in during its lifecycle?
public class Question2 {
	public static void main(String[] args) {
		ThreadLifecycle thread = new ThreadLifecycle();
		System.out.println("State after creation: " + thread.getState()); // NEW

		thread.start();
		System.out.println("State after calling start(): " + thread.getState()); // RUNNABLE

		try {
			Thread.sleep(100); // Give some time for the thread to enter RUNNABLE state
			System.out.println("State while running: " + thread.getState()); // TIMED_WAITING or RUNNABLE

			synchronized (thread) {
				thread.notify(); // Move the thread out of waiting state
			}

			Thread.sleep(100); // Give some time for the thread to complete
			System.out.println("State after completion: " + thread.getState()); // TERMINATED
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadLifecycle extends Thread {
	@Override
	public void run() {
		synchronized (this) {
			try {
				System.out.println("Thread is going to WAITING state");
				wait(); // WAITING
				System.out.println("Thread is back to RUNNABLE state after waiting");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			System.out.println("Thread is going to sleep for 1 second");
			Thread.sleep(1000); // TIMED_WAITING
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread is completing its execution");
	}
}
