package capitulo2;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* O pacote servlet tem 7 interfaces, uma delas é a interface Servlet */

// Ao invés de ser uma herança HttpServlet, está implementando a Interface Servlet
public class PrimitiveServlet implements Servlet {

	/* MÉTODOS QUE SÃO OS CICLOS DE VIDA DO SERVLET */
	
	// Método Init que é o principal quando o Servlet tiver sido criada/demonstrada
	// É chamado uma única vez
	// Também é importante pois ele recebe como parâmetro o ServletConfig
	// O ServletConfig contém os valores declarados no web.xml
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// Quando acessar a Url desse servlet, ele só vai mostrar uma única vez esse out println no Console
		System.out.println("Chamou o init");
	}
	
	// É chamado quando ele for destruído
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

	// É chamado pelo Contentor do Servlet depois que o método init do servlet, permitir ao servlet, responder uma solicitação
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Quando acessar a Url desse servlet, ele vai mostrar na primeira vez e toda vez que der f5 na página
		System.out.println("Chamou o service");
	}

}
