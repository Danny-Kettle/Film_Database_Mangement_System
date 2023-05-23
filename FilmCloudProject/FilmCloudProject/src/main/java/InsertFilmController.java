

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


import model.FilmDAO;
import model.Film;

/**
 * Servlet implementation class InsertFilmController
 */
@WebServlet("/insert")
public class InsertFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFilmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Initialisation
		FilmDAO dao = new FilmDAO();
		System.out.println("Entered DAO");
	
		ArrayList<Film> allFilms = dao.getAllFilms();
		Film lastFilm = dao.getLastFilm(allFilms);
		
		
		//Setting Parameters
		int id = lastFilm.getId() + 1;
		String title = request.getParameter("title");
		int year = Integer.parseInt(request.getParameter("year"));
        String director = request.getParameter("director");
        String stars = request.getParameter("stars");
        String review = request.getParameter("review");
        Film newFilm = new Film(id, title, year, director, stars, review);
        
        try {
        	dao.insertFilm(newFilm);	
        }catch(SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
}
