package capitulo2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Nesse servlet é para demostrar o exemplo da interface ServletRequest, que é um dos parâmetros do método SERVICE
// É usado em conjunto com o html requestDemoServlet.html, lá tendo o input de um texto simples (author name)
// E o form Action aponta para a url desse servlet
// Então quando ele da o submit, ele envia um Post para a url desse servlet
// Que é tratado pelo método Service, onde o ServletRequest tem as informações da Requisição (incluindo o valor digitado no input de Author)
public class RequestDemoServlet implements Servlet {

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

	// Com o parâmetro do ServletRequest, temos acesso a vários atributos
	// Tais como: o server port, name, o protocolo, etc.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		// Coloca no console algumas informações da requisição
		System.out.println("Server Port: " + req.getServerPort());
		System.out.println("Server Name: " + req.getServerName());
		System.out.println("Protocol: " + req.getProtocol());
		System.out.println("Character Encoding: " + req.getCharacterEncoding());
		System.out.println("Content Type: " + req.getContentType());
		System.out.println("Content Length: " + req.getContentLength());
		System.out.println("Remote Address: " + req.getRemoteAddr());
		System.out.println("Remote Host: " + req.getRemoteHost());
		System.out.println("Scheme: " + req.getScheme());

		// Pega todos os nomes de parâmetros feitos na requisição
		Enumeration<String> parameters = req.getParameterNames();
		while (parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			System.out.println("Parameter Name: " + parameter);
			System.out.println("Parameter Value: " + req.getParameter(parameter));
		}

		// Pega todos os nomes de atributos feitosn a requisição
		Enumeration<String> attributes = req.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println("Attribute Name: " + attribute);
			System.out.println("Attribute Value: " + req.getAttribute(attribute));
		}

	}

}