package com.sansone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ContatoDao;

/**
 * Servlet implementation class HiFive
 */
@WebServlet(description = "Exemplo de Tomcat com hello", urlPatterns = { "/HiFive" })
public class HiFive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiFive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("html/index.html");
		
		PrintWriter out = response.getWriter();
		out.println("Super Hi Five!!!!");
		System.out.println("Super Hi Five!!!!");
		
		ArrayList<String> nomes = new ArrayList<>() ;
		
		ContatoDao p = new ContatoDao();
		
		//nomes = p.getNome();

/*		for (int i = 0; i < stringList.size(); i++)
		   String item = stringList.get(i);
		   System.out.println("Item " + i + " : " + item);
		}
*/		
		
		for(String item: nomes){
			out.println("retrieved element: " + item);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
