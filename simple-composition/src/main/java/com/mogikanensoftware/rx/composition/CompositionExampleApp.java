package com.mogikanensoftware.rx.composition;

import com.mogikanensoftware.rx.composition.bean.SecurityRole;
import com.mogikanensoftware.rx.composition.service.UserService;

import rx.Observable;
import rx.schedulers.Schedulers;

public class CompositionExampleApp {

	public static void main(String[] args) throws InterruptedException {

		Object waitMonitor = new Object();

		synchronized (waitMonitor) {
			UserService userService = new UserService();

			System.out.println(Thread.currentThread().getName());
			System.out.println("Filtering Power Users only...");
			System.out.println("Power Users");

			Observable.from(userService.fetchAllUsers()).filter((user) -> {
				return user.getRole().equals(SecurityRole.PowerUser);
			}).map((user) -> {
				return user.getEmail();
			}).subscribeOn(Schedulers.io()).subscribe((email) -> {
				System.out.println(email);
				// emulate heavy processing
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}, (t) -> {
				System.out.println("Smth. went wrong->" + t.getMessage());
			}, () -> {
				System.out.println("Done processing.");
				synchronized (waitMonitor) {
					waitMonitor.notifyAll();
				}
				
			});

			System.out.println("Done in Main.");
			
			waitMonitor.wait();
		}

		System.exit(0);

	}

}
