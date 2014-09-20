package controllers.hello;

import play.mvc.Controller;
import utils.ReverseRouting;

/**
 * <pre>
 * Accept header	      Format	Template file name	Mapping
 *    null	                null	index.html	Default template extension for null format
 *    image/png	            null	index.html	Media type not mapped to a format
 *    image/png	            html	index.html	Default media type mapped to html format    
 *    text/html	            html	index.html	Built-in format
 *    application/xhtml	    html	index.html	Built-in format
 *    text/xml	             xml	index.xml	Built-in format
 *    application/xml	     xml	index.xml	Built-in format
 *    text/plain	         txt	index.txt	Built-in format
 *    text/javascript	    json	index.json	Built-in format
 *    application/json   	json	index.json	Built-in format, default media type ignored
 * 
 * </pre>
 */
public class Hellos extends Controller {

  public static void index() {
    System.out.println("------Hellos.index-----");
    ReverseRouting.reverseTest();
  }

  public static void xml() {
    play.mvc.Http.Request r = request;
    r.format = "xml";
    System.out.println("------");
    String address = "大河南";
    render(address);
  }

  public static void css() {
    request.format = "css";
    render();
  }
}
