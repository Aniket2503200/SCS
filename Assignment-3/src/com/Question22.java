package com;
//Question22

//Create a multi-threaded program that uses ExecutorService to manage a
//pool of threads.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Question22 {
	public static void main(String[] args) throws InterruptedException {
		// Create a fixed-size thread pool with 3 threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Submit tasks to the thread pool
		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executorService.submit(() -> {
				System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
				// Simulate some task execution time
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		// Shutdown the executor service
		executorService.shutdown();

		// Await termination of all tasks for up to 5 seconds
		boolean tasksCompleted = executorService.awaitTermination(5, TimeUnit.SECONDS);

		if (!tasksCompleted) {
			// If tasks are not completed within 5 seconds, force shutdown
			System.out.println("Forcing shutdown of ExecutorService...");
			executorService.shutdownNow();
		}
	}
}
