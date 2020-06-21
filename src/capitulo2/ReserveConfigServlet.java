package capitulo2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Caso queira guardar o ServletConfig, basta criar um objeto para esse servlet do escopo da classe
// E no método init, que é o primeiro a ser chamado, e também recebe o servletconfig, fazer o set do objeto
public class ReserveConfigServlet implements Servlet {
	
	// Declara o objeto do escopo para a classe ReserveConfigServlet
	// Então em qualquer método você tem acesso as configurações do servlet
	ServletConfig servletConfig;
	
	// No método init, que é o primeiro a ser chamado
	// Muda o objeto do escopo da classe
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}
	
	@Override
	public void destroy() {
		servletConfig = null;
	}

	// Agora que estamos guardando a config do servlet no objeto
	// Temos o que retornar
	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	// Método service que é chamado após o f5 e também no iniciar
	// Ele pega o contexto do servlet, que contém os attributos
	// Como as informações do servidor, a versão minor e major, etc.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletContext servletContext = servletConfig.getServletContext();
		Enumeration<String> attributes = servletContext.getAttributeNames();
		while(attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println("Attribute name : " + attribute);
			System.out.println("Attribute value : " + servletContext.getAttribute(attribute));
			System.out.println("Major Version : " + servletContext.getMajorVersion());
			System.out.println("Minor Version : " + servletContext.getMinorVersion());
			System.out.println("Server Info : " + servletContext.getServerInfo());
		}
		
	}

}
