package fr.eni.nombreMystere.ihm;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class nombreMystereServlet
 */
@WebServlet("/jouer")

public class nombreMystereServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Random rdm = new Random();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//afficher la page
		request.getRequestDispatcher("/WEB-INF/jeu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tentative = Integer.parseInt(request.getParameter("tentative"));
		//création de la session 
		HttpSession session = request.getSession();
		
		//voir si le nombre mystere est déjà en session
		Integer nbMystere = (Integer) session.getAttribute("nbMystere");
		//si pas nombre mystere dans la session
		if(nbMystere == null) {
			nbMystere = rdm.nextInt(10)+1;
			session.setAttribute("nbMystere", nbMystere);
			System.out.println("nbMystere : "+ nbMystere);
		}
    	request.setAttribute("gain", false);
    	if(nbMystere == tentative) {
    		request.setAttribute("gain", true);
    		//suppression de l'attribut car gain = true
    		session.removeAttribute("nbMystere");
    	}
		//affichage dans la jsp
		request.getRequestDispatcher("/WEB-INF/jeu.jsp").forward(request, response);
	}

}
