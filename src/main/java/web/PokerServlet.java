package web;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartes.Carte;
import cartes.JeuCarte;

/**
 * Servlet implementation class PokerServlet
 */
@WebServlet("/poker")
public class PokerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * New game / reset or just go on
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		JeuCarte jeu = (JeuCarte) session.getAttribute("jeu");
		boolean reset = Boolean.parseBoolean(request.getParameter("reset"));
		if (Objects.isNull(jeu)||reset) {
			jeu = new JeuCarte(true);
			session.setAttribute("jeu", jeu);
		} else {
			Carte carte = jeu.retirer();
			request.setAttribute("carte", carte);
		}
		RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/cartes.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
