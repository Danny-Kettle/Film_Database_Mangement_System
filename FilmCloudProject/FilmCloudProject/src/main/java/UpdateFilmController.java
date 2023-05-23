


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FilmDAO;
import model.Film;

/**
 * Servlet implementation class UpdateFilmController
 */
@WebServlet("/update")
public class UpdateFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFilmController() {
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
		
		//Initiating 
				FilmDAO dao = new FilmDAO();
				
				//Getting Parameters
				String search = request.getParameter("search");
				
				//Getting Film Parameters
				int id = Integer.parseInt(request.getParameter("id"));
				String title = request.getParameter("title");
				int year = Integer.parseInt(request.getParameter("year"));
		        String director = request.getParameter("director");
		        String stars = request.getParameter("stars");
		        String review = request.getParameter("review");

		        //Initialising Film
		        Film film = new Film(id, title, year, director, stars, review);
		        System.out.println(film);
		        
		        //Call DAO function to execute update query
		        try{
		        	dao.updateFilm(film);
		        }catch(SQLException ex) {
		            throw new ServletException(ex);
		        }
		        
		        System.out.println("Search = " + search);
		        
		        //Check to forward page to the same place it was 
		        if(search == "" || search == "*"){
		        	request.getRequestDispatcher("get-all-films").forward(request,response);
		        }else {
		            request.getRequestDispatcher("search").forward(request,response);
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
