package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class BlogPost extends Controller {

	public static void index() {
		render();
	}
	
	private static void addComment(String content) {
		Comment input = new Comment(content);
		input.save();
	}

	public static void submitComment(String content) {
		addComment(content);
		index();
	}
	
}