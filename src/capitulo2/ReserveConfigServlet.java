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
// E no m�todo init, que � o primeiro a ser chamado, e tamb�m recebe o servletconfig, fazer o set do objeto
public class ReserveConfigServlet implements Servlet {
	
	// Declara o objeto do escopo para a classe ReserveConfigServlet
	// Ent�o em qualquer m�todo voc� tem acesso as configura��es do servlet
	ServletConfig servletConfig;
	
	// No m�todo init, que � o primeiro a ser chamado
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

	// M�todo service que � chamado ap�s o f5 e tamb�m no iniciar
	// Ele pega o contexto do servlet, que cont�m os attributos
	// Como as informa��es do servidor, a vers�o minor e major, etc.
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
