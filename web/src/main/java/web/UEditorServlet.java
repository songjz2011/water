package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UEditorServlet extends HttpServlet {

	private static final long serialVersionUID = 8363868884012154013L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("------------我是谁...");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
