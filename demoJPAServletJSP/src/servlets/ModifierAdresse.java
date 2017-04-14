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
 * Servlet implementation class ModifierAdresse
 */
@WebServlet("/ModifierAdresse")
public class ModifierAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierAdresse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		/**
		 * ModifierAdresse
		 */
		if (request.getParameter("action") != null && request.getParameter("action").equals("toFormModifierAdresse")) {
			request.getRequestDispatcher("/ModifierAdresse.jsp").forward(request, response);
		}

		if (request.getParameter("action") != null && request.getParameter("action").equals("fromFormModifierAdresse")) {

			int id = Integer.parseInt(request.getParameter("id").toString());
			String numRue = request.getParameter("numRue");
			String codePostal = (String) request.getParameter("codePostal");
			String ville = (String) request.getParameter("ville");
			String commentaire = (String) request.getParameter("commentaire");

			Iservice iserv = new Service();
			Adresse a = iserv.findAdresse(id);
			a.setNumRue(numRue);
			a.setCodePostal(codePostal);
			a.setVille(ville);
			a.setCommentaire(commentaire);
			iserv.modifierAdresse(a);

			request.setAttribute("modifOk", "ok");
			request.getRequestDispatcher("/ModifierAdresse.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
