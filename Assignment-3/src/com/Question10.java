package com;

//Question10
//Explain the use of wait(), notify(), and notifyAll() methods. Provide
//an example demonstrating their usage.
public class Question10 {
	public static void main(String[] args) {
		Message11 Message11 = new Message11();

		Thread producerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Message11.produce("Message11 " + i);
			}
		});

		Thread consumerThread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Message11.consume();
			}
		});

		Thread consumerThread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Message11.consume();
			}
		});

		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
	}
}

class Message11 {
	private String Message11;
	private boolean produced = false;

	public synchronized void produce(String msg) {
		while (produced) {
			try {
				wait(); // Wait for the consumer to consume the Message11
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
		this.Message11 = msg;
		System.out.println("Produced: " + msg);
		produced = true;
		notify(); // Notify a single consumer that a new Message11 is available
	}

	public synchronized void consume() {
		while (!produced) {
			try {
				wait(); // Wait for the producer to produce a Message11
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
		System.out.println("Consumed: " + Message11);
		produced = false;
		notifyAll(); // Notify all waiting producers that the Message11 has been consumed
	}
}
