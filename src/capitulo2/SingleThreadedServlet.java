package capitulo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;

// Extends GenericServlet para implementar somente o método Service
// Implementa a interface SingleThreadModel para acessar o recurso externo em uma única thread

// Sem a implementação da interface SingleThreadModel, se mais de um usuário acessar esse servlet
// O Contador não vai mostrar os dados corretamente, pois mais de um thread vai acessar e modificar ele simultanameante
// A interface faz que uma única thread por vez, acesse o recurso externo (no caso o counter.txt)
@SuppressWarnings("deprecation")
public class SingleThreadedServlet extends GenericServlet implements SingleThreadModel {


	public static final String PATH_FILE = "C:\\Users\\rafae\\Desktop";
	private static final long serialVersionUID = 1L;
	
	private File counterTxt = new File(PATH_FILE+"\\counter.txt");

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
       int counter = 0;
       
       if(!counterTxt.canRead() || !counterTxt.canWrite()) {
    	   counterTxt.createNewFile();
       }
     
       // Cria um BufferedReader para ler o File
       try {
    	   // Instancia o Buffered Reader
    	   BufferedReader reader = new BufferedReader(new FileReader(counterTxt));
    	   // Lê a linha e passa a linha para um inteiro
    	   counter = Integer.parseInt(reader.readLine());
    	   // Fecha o Reader
    	   reader.close();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
       
       // Soma o Contador
       counter++;
       
       // escreve o novo contador no arquivo counter.txt, com um BufferedWriter
       try {
    	   BufferedWriter writer = new BufferedWriter(new FileWriter(counterTxt));
    	   writer.write(Integer.toString(counter));
    	   writer.close();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
       
       // Imprime no html o valor atual do Contador
       try {
    	   PrintWriter out = res.getWriter();
    	   out.println("Contador: " + counter);
       }catch(Exception e) {
    	   e.printStackTrace();
       }
		
	}

}
