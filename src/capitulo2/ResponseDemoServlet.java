package capitulo2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ResponseDemoServlet implements Servlet {

	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
			out.println("Testando o ServletResponse");
		out.println("</TITLE>");
		out.println("</HEAD>");
		
		out.println("<BODY>");
		
		out.println("<H1> Demonstrando o ServletResponse </H1>");
		
		// Coloca no console algumas informações da requisição
		out.println("<BR/> Server Port: " + req.getServerPort());
		out.println("<BR/> Server Name: " + req.getServerName());
		out.println("<BR/> Protocol: " + req.getProtocol());
		out.println("<BR/> Character Encoding: " + req.getCharacterEncoding());
		out.println("<BR/> Content Type: " + req.getContentType());
		out.println("<BR/> Content Length: " + req.getContentLength());
		out.println("<BR/> Remote Address: " + req.getRemoteAddr());
		out.println("<BR/> Remote Host: " + req.getRemoteHost());
		out.println("<BR/> Scheme: " + req.getScheme());

		// Pega todos os nomes de parâmetros feitos na requisição
		Enumeration<String> parameters = req.getParameterNames();
		while (parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			out.println("<BR/> Parameter Name: " + parameter);
			out.println("<BR/> Parameter Value: " + req.getParameter(parameter));
		}

		// Pega todos os nomes de atributos feitosn a requisição
		Enumeration<String> attributes = req.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			out.println("<BR/> Attribute Name: " + attribute);
			out.println("<BR/> Attribute Value: " + req.getAttribute(attribute));
		}
		
		out.println("</BODY>");
		
		out.println("</HTML>");

	}

}
