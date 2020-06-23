package capitulo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A classe HttpServlet, mais atual, extende de GenericServlet
// Ela tem os métodos doGet, doPost, doDelete, doPatch (são os 4 mais utilizados)
// doNOME_DO_METODO_DA_WEB, o mais comum é o doGet, que é a requisição padrão
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Quando você acessa o endereço de um servlet, ele da um get no endereço, ou
	// seja toda vez que você acessar um site
	// Você está fazendo um get para pegar os dados para aquela página
	// E no caso abaixo você está retornando text/html (ele muda o ContentType da
	// Response)
	// E retorna um formulário com o método Post e um input do tipo Submit para
	// enviar o formulário
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); // Fala que o tipo do retorno vai ser um texto Html (Content é o conteúdo)

		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("The Get Method");
		out.println("</TITLE>");
		out.println("</HEAD>");

		out.println("<BODY>");

	
		out.println("<H1> Headers of the get request </H1>");
		// Você tem como pegar o cabeçalho da requisição, pela classe HttpServletRequest
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

	// Quando ele clicar no button submit, ele irá fazer um post pra url, no caso a
	// mesma e irá chamar esse método
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
