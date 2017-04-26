package com.mogikanensoftware.rx.composition;

import com.mogikanensoftware.rx.composition.bean.SecurityRole;
import com.mogikanensoftware.rx.composition.service.UserService;

import rx.Observable;

public class CompositionExampleApp {

	public static void main(String[] args) {

		UserService userService = new UserService();

		System.out.println(Thread.currentThread().getName());
		System.out.println("Filtering Power Users only...");
		System.out.println("Power Users");

		Observable.from(userService.fetchAllUsers()).filter((user) -> {
			return user.getRole().equals(SecurityRole.PowerUser);
		}).subscribe((user) -> System.out.println(user));

		System.out.println("Done.");
		System.exit(0);

	}

}
