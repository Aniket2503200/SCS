package com;

//Question14
//Explain the purpose of the Callable interface and Future class.
//Provide an example demonstrating their usage.
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question14 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		// Submitting a Callable task to ExecutorService
		Future<Long> futureResult = executorService.submit(new FactorialCalculator(10));

		System.out.println("Task submitted, waiting for result...");

		try {
			// Blocking call to get the result of the computation
			long factorial = futureResult.get();
			System.out.println("Factorial of 10 is: " + factorial);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Shutdown the executor service
		executorService.shutdown();
	}
}

class FactorialCalculator implements Callable<Long> {
	private final int number;

	public FactorialCalculator(int number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		if (number < 0) {
			throw new IllegalArgumentException("Number should be non-negative.");
		}

		long factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
