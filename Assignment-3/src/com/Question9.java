package com;

//Question9
//What mechanisms are available in Java for thread communication?
public class Question9 {
	public static void main(String[] args) {
		Message message = new Message();

		Thread producerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				String msg = "Message " + i;
				message.produce(msg);
			}
		});

		Thread consumerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				message.consume();
			}
		});

		producerThread.start();
		consumerThread.start();
	}
}

class Message {
	private String message;
	private boolean produced = false;

	public synchronized void produce(String msg) {
		while (produced) {
			try {
				wait(); // Wait for the consumer to consume the message
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
		this.message = msg;
		System.out.println("Produced: " + msg);
		produced = true;
		notify(); // Notify the consumer that a new message is available
	}

	public synchronized void consume() {
		while (!produced) {
			try {
				wait(); // Wait for the producer to produce a message
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
		System.out.println("Consumed: " + message);
		produced = false;
		notify(); // Notify the producer that the message has been consumed
	}
}
