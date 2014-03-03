package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CkEditorServlet extends HttpServlet {

	private static final long serialVersionUID = 7194102212511974727L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String value = req.getParameter("textarea1");
		System.out.println(value);
		req.setAttribute("value", value);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
