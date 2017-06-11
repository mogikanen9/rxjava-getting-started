package com.mogikanensoftware.lynda.thread.join;

public class TestJoinExample {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		TestJoinThread t1 = new TestJoinThread("t1");
		TestJoinThread t2 = new TestJoinThread("t2");
		TestJoinThread t3 = new TestJoinThread("t3");
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		t2.start();
		// thread 3 won't start until thread 2 is complete
		t3.start();
	}

}
