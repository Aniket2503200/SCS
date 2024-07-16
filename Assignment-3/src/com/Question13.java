package com;

//Question13
//What is the ExecutorService in Java, and how does it differ from
//managing threads manually?
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question13 {
	public static void main(String[] args) {
		// Create an ExecutorService with a fixed-size thread pool
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Submit tasks to the executor service
		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executorService.submit(() -> {
				System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
			});
		}

		// Shutdown the executor service gracefully
		executorService.shutdown();
	}
}
