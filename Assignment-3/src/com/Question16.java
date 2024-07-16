package com;

//Question16
//Describe what is meant by a livelock and how it differs from a deadlock.
public class Question16 {
	static class Spoon {
		private Diner owner;

		public Spoon(Diner owner) {
			this.owner = owner;
		}

		public synchronized void use() {
			System.out.printf("%s has eaten!", owner.name);
		}

		public synchronized void setOwner(Diner diner) {
			this.owner = diner;
		}
	}

	static class Diner {
		private String name;
		private boolean isHungry;

		public Diner(String name) {
			this.name = name;
			this.isHungry = true;
		}

		public void eatWith(Spoon spoon, Diner spouse) {
			while (isHungry) {
				// Try to take the spoon
				if (spoon.owner != this) {
					try {
						Thread.sleep(1); // Simulate thinking
					} catch (InterruptedException e) {
						continue;
					}
					continue;
				}

				// Spoon is owned, check if spouse is hungry
				if (spouse.isHungry) {
					System.out.printf("%s: You eat first my darling %s!%n", name, spouse.name);
					spoon.setOwner(spouse);
					continue;
				}

				// Eat
				spoon.use();
				isHungry = false;
				System.out.printf("%s: I am stuffed, my dear %s!%n", name, spouse.name);
				spoon.setOwner(spouse);
			}
		}
	}

	public static void main(String[] args) {
		final Diner husband = new Diner("Bob");
		final Diner wife = new Diner("Alice");

		final Spoon spoon = new Spoon(husband);

		new Thread(() -> husband.eatWith(spoon, wife)).start();
		new Thread(() -> wife.eatWith(spoon, husband)).start();
	}
}
