package capitulo2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* OBS: ESSE SERVLET É USADO EM CONJUNTO COM O AttributeSetterServlet
 * Você tem que chamar a url do servlet AttributeSetterServlet primeiro
 * e depois acessar a url deste servlet para pegar o atributo que foi criado no AttributeSetterServlet
 */

public class DisplayAttributeServlet implements Servlet {
	
	ServletConfig servletConfig;

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
		servletConfig = config;
	}

	// Faz um while para pegar todos os attributes que estão no contexto do Servlet
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletContext servletContext = servletConfig.getServletContext();
		Enumeration<String> attributes = servletContext.getAttributeNames();
		while(attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println("Attribute name : " + attribute);
			System.out.println("Attribute value : " + servletContext.getAttribute(attribute));
		}
	}

}