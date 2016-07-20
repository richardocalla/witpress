package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Blog extends Controller {

	public static void index() {
		User user = Accounts.getCurrentUser();
		
		List<Post> reversePosts = new ArrayList<Post> (user.posts);
		Collections.reverse(reversePosts);
		render(user, reversePosts);
	}

	public static void addPost(String content, String title) {
		User user = Accounts.getCurrentUser();
		
		Post input = new Post(content, title);
		user.submitPost(input);
		user.save();
		
		Logger.info ("title:" + title + " content:" + content);
	    index();
	}

}