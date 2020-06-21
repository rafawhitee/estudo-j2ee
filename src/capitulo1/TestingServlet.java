package capitulo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
			out.println("<TITLE> Testing Servlet </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
			out.println("Testando Servlet Inicial");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
