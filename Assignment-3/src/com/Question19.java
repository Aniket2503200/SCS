package com;

//Question19
//How can you ensure that a class is thread-safe? Provide examples of
//thread-safe and non-thread-safe classes.
import java.util.concurrent.atomic.AtomicInteger;

// Non-thread-safe Counter4 class
class Counter4 {
	private int count;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

// Thread-safe Counter4 class using AtomicInteger
class AtomicCounter4 {
	private AtomicInteger count = new AtomicInteger(0);

	public void increment() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}
}

public class Question19 {
	public static void main(String[] args) throws InterruptedException {
		// Non-thread-safe Counter4 example
		Counter4 Counter4 = new Counter4();
		Thread[] threads = new Thread[10];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					Counter4.increment(); // Unsafe increment
				}
			});
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("Non-thread-safe Counter4 result: " + Counter4.getCount()); // Result may vary

		// Thread-safe Counter4 example
		AtomicCounter4 atomicCounter4 = new AtomicCounter4();

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					atomicCounter4.increment(); // Safe increment
				}
			});
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("Thread-safe Counter4 result: " + atomicCounter4.getCount()); // Expected result: 10000
	}
}
