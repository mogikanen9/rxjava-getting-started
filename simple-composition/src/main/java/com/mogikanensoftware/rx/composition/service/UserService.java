package com.mogikanensoftware.rx.composition.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mogikanensoftware.rx.composition.bean.SecurityRole;
import com.mogikanensoftware.rx.composition.bean.User;

public class UserService {

	private final List<User> allUsers;

	public UserService() {
		allUsers = new ArrayList<>();
		allUsers.add(new User("vasya.pupkin", "vasya.pupkin@qwe.com", SecurityRole.Administrator));
		allUsers.add(new User("ejik.polevoi", "ejik.polevoi@qwe.com", SecurityRole.Guest));
		allUsers.add(new User("lena.zosina", "lena.zosina@qwe.com", SecurityRole.PowerUser));
		allUsers.add(new User("eva.brown", "eva.brown@qwe.com", SecurityRole.Administrator));
		allUsers.add(new User("kozel.usatov", "kozel.usatov@qwe.com", SecurityRole.PowerUser));
	}

	public List<User> fetchAllUsers() {
		System.out.println("Emulate data loading...");
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.unmodifiableList(allUsers);
	}
}
