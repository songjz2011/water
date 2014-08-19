package controllers;

import models.user.User;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;

public class Users extends Controller {

	@Before
	static void addDefaults() {
		renderArgs.put("blogBaseline", Play.configuration.getProperty("blog.baseline"));
	}
	
	public static void index() {
		User user = User.find("order by name").first();
		render(user);
	}

	public static void show(Long id) {
		
	}
}
