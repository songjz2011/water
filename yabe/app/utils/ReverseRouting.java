package utils;

import java.util.HashMap;
import java.util.Map;

import play.mvc.Router;
import play.mvc.Router.Route;

public class ReverseRouting {

	public static void reverseTest() {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", "1");
		String url = Router.getFullUrl("Hellos.index");
		System.out.println("----: " + url);
		
		url = Router.getFullUrl("UserYabes.show", map);
		System.out.println("----: " + url);
	}
	
}
