package com.mogikanensoftware.lynda.thread.sync;

public class ThreadCounterObjectSyncSample {

	public static void main(String[] args) {
		// use lambda notation for the runnable method
		Runnable r = () -> {
			System.out.println("ID value: " + ID.getID());
		};
		Thread one = new Thread(r, "one");
		one.start();
		Thread two = new Thread(r, "two");
		two.start();
	}

}

class ID {
	private static int counter; // initialized to 0 by default

	public static synchronized int getID() {
		return counter++;
	}
}