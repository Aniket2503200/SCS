package com;

//Questin8
//Provide an example of a synchronized block and a synchronized method.
public class Question8 {
	public static void main(String[] args) {
		// Create an instance of SharedResource
		SharedResource resource = new SharedResource();

		// Create and start multiple threads
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				resource.increment();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				resource.increment();
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

		// Print final count
		System.out.println("Final Count (Synchronized Method): " + resource.getCount());

		// Another example with synchronized block
		SharedResourceWithBlock resourceWithBlock = new SharedResourceWithBlock();

		// Create and start multiple threads
		Thread thread3 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				resourceWithBlock.performOperation();
			}
		});

		Thread thread4 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				resourceWithBlock.performOperation();
			}
		});

		// Start threads
		thread3.start();
		thread4.start();

		// Wait for threads to complete
		try {
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print final result
		System.out.println("Final Result (Synchronized Block): " + resourceWithBlock.getResult());
	}
}

class SharedResource {
	private int count;

	// Synchronized method
	public synchronized void increment() {
		count++;
	}

	public synchronized int getCount() {
		return count;
	}
}

class SharedResourceWithBlock {
	private int result;

	public void performOperation() {
		// Synchronized block
		synchronized (this) {
			result++;
		}
	}

	public int getResult() {
		return result;
	}
}
