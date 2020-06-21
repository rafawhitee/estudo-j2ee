package capitulo2;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* O pacote servlet tem 7 interfaces, uma delas � a interface Servlet */

// Ao inv�s de ser uma heran�a HttpServlet, est� implementando a Interface Servlet
public class PrimitiveServlet implements Servlet {

	/* M�TODOS QUE S�O OS CICLOS DE VIDA DO SERVLET */
	
	// M�todo Init que � o principal quando o Servlet tiver sido criada/demonstrada
	// � chamado uma �nica vez
	// Tamb�m � importante pois ele recebe como par�metro o ServletConfig
	// O ServletConfig cont�m os valores declarados no web.xml
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// Quando acessar a Url desse servlet, ele s� vai mostrar uma �nica vez esse out println no Console
		System.out.println("Chamou o init");
	}
	
	// � chamado quando ele for destru�do
	@Override
	public void destroy() {
		System.out.println("Chamou o destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	// � chamado pelo Contentor do Servlet depois que o m�todo init do servlet, permitir ao servlet, responder uma solicita��o
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Quando acessar a Url desse servlet, ele vai mostrar na primeira vez e toda vez que der f5 na p�gina
		System.out.println("Chamou o service");
	}

}
