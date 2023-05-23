

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import model.FilmDAO;
import model.Film;

/**
 * Servlet implementation class DeleteFilmController
 */
@WebServlet("/delete")
public class DeleteFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilmController() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id + ", " + search);	
        Film film = dao.getFilmByID(id);
        
        //Call DAO Function to execute delete query
        try {
            dao.deleteFilm(film);
            System.out.println("Deleted Film");
        }catch(SQLException ex) {
            throw new ServletException(ex);
        }
        
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
