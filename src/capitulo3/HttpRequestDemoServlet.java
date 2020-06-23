package capitulo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Demonstra��o como pegar Query String (os par�metros pela URL)
public class HttpRequestDemoServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;

	// Por exemplo:
	// http://localhost:8080/estudo-j2ee/servlet/httpRequestDemoServlet?FirstName=Rafael&LastName=Nunes
	// A url padr�o desse servlet foi mapeada para http://localhost:8080/estudo-j2ee/servlet/httpRequestDemoServlet
	// o que vem depois � a query string, ou seja o FirstName=Rafael & LastName=Nunes
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); // Fala que o tipo do retorno vai ser um texto Html (Content � o conte�do)

		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("get the query string");
		out.println("</TITLE>");
		out.println("</HEAD>");

		out.println("<BODY>");
		
		// Se voc� apertar o submit do form, ele ir� fazer uma requisi��o get com o formul�rio
		// O Formul�rio padr�o � POST para fazer o submit (e os par�metros v�o escondidos no body da requisi��o
		// Se voc� fizer um submit com GET, ele ir� colocar os par�metros na URL ( no caso query string )
		out.println("<H1> Fazendo um loop percorrendo todos os ParametersName (se tiver), no caso depois do submit do formul�rio </H1>");
		Enumeration<String> parameters = req.getParameterNames();
		while(parameters.hasMoreElements()) {
			String parameter = parameters.nextElement();
			out.println(parameter + ": " + req.getParameter(parameter) + "<BR/>");
		}
		
		out.println("<H1> M�todo getQueryString: </H1>");
		out.println("Query String: " + req.getQueryString() + "<BR/>");
		
		out.println("<BR/>");
		out.println("<FORM METHOD=GET>");
		out.println("<BR/> Primeiro Nome: <INPUT TYPE=TEXT NAME=FirstName>");
		out.println("<BR/> Ultimo Nome: <INPUT TYPE=TEXT NAME=LastName>");
		out.println("<INPUT TYPE=SUBMIT value=Submit>");
		out.println("</FORM>");


		out.println("</BODY>");

		out.println("</HTML>");
	}

}
