package com.mogikanensoftware.rx.creation;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class SubscribeOnThreadExample {

	public static void main(String[] args) {
		Object waitMonitor = new Object();

		synchronized (waitMonitor) {

			List<Integer> fibonacciList = Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34);

			Observable<Integer> observableList = Observable.from(fibonacciList);

			observableList.subscribeOn(Schedulers.newThread()).subscribe((i) -> {
				System.out.println(i);
				System.out.println(String.format("Currrent thread ->%s", Thread.currentThread().getName()));
			}, (t) -> {
				t.printStackTrace();
			}, () -> {
				System.out.println("Complete");
				synchronized (waitMonitor) {
					waitMonitor.notify(); //notify that eveyrthing is over
				}
			});
		}

		//wait for monitor
		synchronized (waitMonitor) {
			try {
				waitMonitor.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// System.exit(0);
	}
}
