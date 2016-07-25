package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Blog extends Controller {

	public static void index() {
		User user = Accounts.getCurrentUser();
		if (user == null) {
			Accounts.index();
		}
		
		List<Post> reversePosts = new ArrayList<Post>(user.posts);
		Collections.reverse(reversePosts);
		render(user, reversePosts);
	}

	public static void addPost(String content, String title) {
		User user = Accounts.getCurrentUser();

		Post post = new Post(content, title);
		user.submitPost(post);
		user.save();

		Logger.info("title:" + title + " content:" + content);
		index();
	}

	public static void deletePost(Long postid) {
		User user = Accounts.getCurrentUser();

		Post post = Post.findById(postid);
		user.posts.remove(post);

		user.save();
		post.delete();

		index();
	}

}