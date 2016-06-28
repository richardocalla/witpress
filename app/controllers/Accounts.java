package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Accounts extends Controller {

	public static void index() {
		render();
	}

	public static void register(User user) {
		user.save();
		signin();
	}

	public static void signin() {
		render();
	}

	public static void signout() {
		session.clear();
		index();
	}

	public static User getCurrentUser() {
		String userId = session.get("logged_in_userid");
		if (userId == null) {
			return null;
		}
		User logged_in_user = User.findById(Long.parseLong(userId));
		Logger.info("Logged in user is " + logged_in_user.firstName);
		return logged_in_user;
	}

	public static void authenticate(String email, String password) {
		Logger.info("Attempting to authenticate with " + email + ":" + " " + password);

		User user = User.findByEmail(email);
		if ((user != null) && (user.checkPassword(password) == true)) {
			Logger.info("Authentication successful");
			session.put("logged_in_userid", user.id);
			index();
		} else {
			Logger.info("Authentication failed");
			signin();
		}
	}

}