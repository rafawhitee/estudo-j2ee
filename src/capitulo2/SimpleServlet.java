package capitulo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


// Ao invés de implementar a interface Servlet, extende a classe GenericServlet
// Pois a interface é um contrato, quando você implementa o contrato, é obrigado a escrever todos os métodos dela
// Já com herança não, no caso do GenericServlet o único que você implementa é o método Service
public class SimpleServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> EXTENDS GENERIC SERVLET </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Extendendo a Classe GenericServlet");
		out.println("</BODY>");		
		out.println("</HTML>");
	}

}
