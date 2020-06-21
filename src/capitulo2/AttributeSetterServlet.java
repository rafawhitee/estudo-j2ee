package capitulo2;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* OBS: ESSE SERVLET � USADO EM CONJUNTO COM O DisplayAttributeServlet 
 * Voc� tem que chamar esse primeiro, e depois acessar a url do outro servlet para ele mostrar o atributo password
 */

// Demonstra��o de como compartilhar informa��es entre diferentes Servlets
public class AttributeSetterServlet implements Servlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Ele pega o context e faz um setAttribute, para criar um novo atributo no contexto servlet
		// Ent�o se em outro servlet voc� pegar os attributes que retorna uma lista de Enumeration<String>
		// Esse atributo abaixo, 'password', estar� l� e com o valor '123456789'
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
