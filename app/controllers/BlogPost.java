package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class BlogPost extends Controller {

	public static void index(Long postid) {
		Post post = Post.findById(postid);
		render(post);
	}
	
	public static void addComment(Long postid, String content) {
		Post post = Post.findById(postid);
		Comment comment = new Comment(content);
		
		post.submitComment(comment);
		post.save();
        index(postid);
	}
	
}