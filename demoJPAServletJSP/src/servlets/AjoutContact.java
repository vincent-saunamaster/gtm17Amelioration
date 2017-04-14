package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Adresse;
import metier.Contact;
import service.Iservice;
import service.Service;

/**
 * Servlet implementation class AjoutContact
 */
@WebServlet("/AjoutContact")
public class AjoutContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AjoutContact() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//request.getRequestDispatcher("/AjoutContact.jsp");
		if (request.getParameter("action") != null && request.getParameter("action").equals("ajoutcontact")) {

			String numRue = request.getParameter("numRue");
			String codePostal = (String) request.getParameter("codePostal");
			String ville = (String) request.getParameter("ville");
			String commentaire = (String) request.getParameter("commentaire");
			
			Adresse a = new Adresse();
			a.setNumRue(numRue);
			a.setCodePostal(codePostal);
			a.setVille(ville);
			a.setCommentaire(commentaire);

			String nom = (String) request.getParameter("nom");
			String prenom = (String) request.getParameter("prenom");
			String email = (String) request.getParameter("email");
			
			Contact c = new Contact();
			c.setNom(nom);
			c.setPrenom(prenom);
			c.setEmail(email);
			
			Iservice iserv = new Service();
			//iserv.ajouterAdresse(a);
			iserv.ajouterContactAdresse(c, a);
			
			request.getRequestDispatcher("/index.html");
		}
		request.getRequestDispatcher("/AjoutContact.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
