package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Adresse;
import service.Iservice;
import service.Service;

/**
 * Servlet implementation class AjouterAdresse
 */
@WebServlet("/AjouterAdresse")
public class AjouterAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterAdresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		/**
		 * AjouterAdresse
		 */
		if (request.getParameter("action") != null && request.getParameter("action").equals("toFormAjouterAdresse")) {
			request.getRequestDispatcher("/AjouterAdresse.jsp").forward(request, response);
		}

		if (request.getParameter("action") != null && request.getParameter("action").equals("fromFormAjouterAdresse")) {

			String numRue = request.getParameter("numRue");
			String codePostal = (String) request.getParameter("codePostal");
			String ville = (String) request.getParameter("ville");
			String commentaire = (String) request.getParameter("commentaire");

			Adresse a = new Adresse();
			a.setNumRue(numRue);
			a.setCodePostal(codePostal);
			a.setVille(ville);
			a.setCommentaire(commentaire);

			Iservice iserv = new Service();
			iserv.ajouterAdresse(a);

			request.setAttribute("ajoutOk", "ok");
			request.getRequestDispatcher("/AjouterAdresse.jsp").forward(request, response);
		}
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
