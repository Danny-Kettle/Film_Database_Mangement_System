

import java.io.IOException;
import java.util.ArrayList;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FilmDAO;
import model.Film;

/**
 * Servlet implementation class SearchFilmController
 */
@WebServlet("/search")
public class SearchFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFilmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Setting Headers
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//Initialisation
		FilmDAO dao = new FilmDAO();
		
		//Setting parameters
		String searchStr = request.getParameter("search");
		
		//Call searchFilms to return an Array of films containing searchStr
		try {
			ArrayList<Film> allFilms = dao.searchFilms(searchStr);
			request.setAttribute("films",allFilms); 
		}catch(SQLException ex) {
			throw new ServletException(ex);
		}
		
		System.out.println("Entered FilmList");
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
