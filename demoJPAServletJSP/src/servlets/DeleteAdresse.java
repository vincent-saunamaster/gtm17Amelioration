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
 * Servlet implementation class DeleteAdresse
 */
@WebServlet("/DeleteAdresse")
public class DeleteAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAdresse() {
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
		 *DeleteAdresse
		 */
		if (request.getParameter("action") != null && request.getParameter("action").equals("toFormDeleteAdresse")) {
			request.getRequestDispatcher("/DeleteAdresse.jsp").forward(request, response);
		}

		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("fromFormDeleteAdresse")) {

			int id = Integer.parseInt(request.getParameter("id").toString());
			Iservice iserv = new Service();
			Adresse a = iserv.findAdresse(id);
			iserv.deleteAdresse(a);

			request.setAttribute("deleteOk", "ok");
			request.getRequestDispatcher("/DeleteAdresse.jsp").forward(request, response);
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
