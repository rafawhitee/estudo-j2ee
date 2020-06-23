package capitulo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A classe HttpServlet, mais atual, extende de GenericServlet
// Ela tem os m�todos doGet, doPost, doDelete, doPatch (s�o os 4 mais utilizados)
// doNOME_DO_METODO_DA_WEB, o mais comum � o doGet, que � a requisi��o padr�o
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Quando voc� acessa o endere�o de um servlet, ele da um get no endere�o, ou
	// seja toda vez que voc� acessar um site
	// Voc� est� fazendo um get para pegar os dados para aquela p�gina
	// E no caso abaixo voc� est� retornando text/html (ele muda o ContentType da
	// Response)
	// E retorna um formul�rio com o m�todo Post e um input do tipo Submit para
	// enviar o formul�rio
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); // Fala que o tipo do retorno vai ser um texto Html (Content � o conte�do)

		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("The Get Method");
		out.println("</TITLE>");
		out.println("</HEAD>");

		out.println("<BODY>");

	
		out.println("<H1> Headers of the get request </H1>");
		// Voc� tem como pegar o cabe�alho da requisi��o, pela classe HttpServletRequest
		Enumeration<String> headersName = req.getHeaderNames();
		while (headersName.hasMoreElements()) {
			String headerName = headersName.nextElement();
			out.println(headerName + ": " + req.getHeader(headerName) + " <BR/>");
		}

		out.println("<H1> The servlet has received a GET. Now Click the button below. </H1>");
		out.println("<BR/>");
		out.println("<FORM METHOD=POST>");
		out.println("<INPUT TYPE=SUBMIT value=Submit>");
		out.println("</FORM>");

		out.println("</BODY>");

		out.println("</HTML>");
	}

	// Quando ele clicar no button submit, ele ir� fazer um post pra url, no caso a
	// mesma e ir� chamar esse m�todo
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("The Post Method");
		out.println("</TITLE>");
		out.println("</HEAD>");

		out.println("<BODY>");

		out.println("<H1> The servlet has received a POST. Thank you! </H1>");

		out.println("</BODY>");

		out.println("</HTML>");
	}

}
