package capitulo2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigDemoServlet implements Servlet {

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
		// Pega todos nomes dos parâmetros iniciais, declarados no web.xml para esse servlet
		Enumeration<String> parameters = config.getInitParameterNames();
		while(parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			System.out.println("Parameter name : " + parameter);
			System.out.println("Parameter value : " + config.getInitParameter(parameter));
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	}

}
