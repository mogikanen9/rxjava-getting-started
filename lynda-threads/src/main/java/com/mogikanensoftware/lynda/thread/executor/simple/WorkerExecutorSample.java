package com.mogikanensoftware.lynda.thread.executor.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerExecutorSample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("Worker" + i);
			// calling execute method of ExecutorService
			executorService.execute(worker);
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		System.out.println("Done");
	}

}
