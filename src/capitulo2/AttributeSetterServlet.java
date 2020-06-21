package capitulo2;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* OBS: ESSE SERVLET É USADO EM CONJUNTO COM O DisplayAttributeServlet 
 * Você tem que chamar esse primeiro, e depois acessar a url do outro servlet para ele mostrar o atributo password
 */

// Demonstração de como compartilhar informações entre diferentes Servlets
public class AttributeSetterServlet implements Servlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Ele pega o context e faz um setAttribute, para criar um novo atributo no contexto servlet
		// Então se em outro servlet você pegar os attributes que retorna uma lista de Enumeration<String>
		// Esse atributo abaixo, 'password', estará lá e com o valor '123456789'
		ServletContext servletContext = config.getServletContext();
		servletContext.setAttribute("password", "123456789");
	}

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
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	}

}
