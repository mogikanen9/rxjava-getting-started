package com.mogikanensoftware.lynda.thread.executor.simple;

public class WorkerThread implements Runnable {

	private String name;

	public WorkerThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println(String.format("Worker %s is doing heavy work ", name));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(String.format("Worker %s finished heavy work ", name));
	}

}
