

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FilmDAO;
import model.Film;

/**
 * Servlet implementation class SearchIdController
 */
@WebServlet("/searchID")
public class SearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController() {
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
		System.out.println(request.getParameter("searchID"));
		int searchStr = Integer.parseInt(request.getParameter("searchID"));
		
		
		//Call searchFilms to return an Array of films containing searchStr
		Film film = dao.getFilmByID(searchStr);
		ArrayList<Film> allFilms = new ArrayList<Film>();
		
		allFilms.add(film);
		
		request.setAttribute("films",allFilms); 
		
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
