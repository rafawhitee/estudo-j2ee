package capitulo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


// Ao inv�s de implementar a interface Servlet, extende a classe GenericServlet
// Pois a interface � um contrato, quando voc� implementa o contrato, � obrigado a escrever todos os m�todos dela
// J� com heran�a n�o, no caso do GenericServlet o �nico que voc� implementa � o m�todo Service
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
