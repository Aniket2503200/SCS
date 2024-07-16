package com;

//Question17
//What are thread pools, and why are they useful in a multi-threaded application?
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question17 {
	public static void main(String[] args) {
		// Create a thread pool with fixed number of threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Submit tasks to the thread pool
		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executorService.submit(() -> {
				System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
			});
		}
		// Shutdown the executor service
		executorService.shutdown();
	}
}
