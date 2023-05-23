package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import model.Film;

public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "kettleda";
    String password = "lorGical7";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }
   
   public Film getLastFilm(ArrayList<Film> films) {
	   Integer size = films.size();
	   System.out.println(films.get(size-1));
	   return films.get(size-1);
   }

   public Film getFilmByID(int id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   
   public void insertFilm(Film f) throws SQLException {
		openConnection();
	    // Create select statement and execute it
		try{
		    String insertSQL = "INSERT INTO films(id,title, year, director, stars, review) VALUES ('" + f.getId() 
		    + "', '" + f.getTitle() + "', '" + f.getYear() + "', '" + f.getDirector() + "', '" + f.getStars() + "', '" + f.getReview() + "')";
		    System.out.println(insertSQL);
		    PreparedStatement preparedStmt = conn.prepareStatement(insertSQL);
		    preparedStmt.execute();
		    preparedStmt.close();
		    closeConnection();
		    
		} catch(SQLException se) { System.out.println(se); }  
	}
   
   public void updateFilm(Film f) throws SQLException {
	   openConnection();
	    // Create select statement and execute it
		try{
		    String updateSQL = "UPDATE films SET title = '" + f.getTitle() + "', year= " + f.getYear() 
		    + ", director = '" + f.getDirector() + "', stars ='" + f.getStars() 
		    + "', review = '" + f.getReview() + "' WHERE id =" + f.getId();
		    System.out.println(updateSQL);
		    PreparedStatement preparedStmt = conn.prepareStatement(updateSQL);
		    preparedStmt.execute();
		    preparedStmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }  
   }
   
   public void deleteFilm(Film film) throws SQLException {
		openConnection();
	    // Create Delete statement and execute it
		try{
		    String deleteSQL = "DELETE FROM films where id = "+ film.getId();
		    PreparedStatement preparedStmt = conn.prepareStatement(deleteSQL);
		    preparedStmt.execute();
		    preparedStmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }
   }
   
   public ArrayList<Film> searchFilms(String searchStr) throws SQLException{
	   openConnection();
	   ArrayList<Film> films = new ArrayList<Film>();
	   try {
		   String selectSQL = "SELECT DISTINCT * FROM films WHERE CONCAT_WS(',',title,year,director,stars,review) LIKE '%" + searchStr + "%'";
		   System.out.println(selectSQL);
		   ResultSet rs1 = stmt.executeQuery(selectSQL);
		   // Retrieve the results
		   while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	films.add(oneFilm);
		   }
	   } catch(SQLException se) { System.out.println(se); }  
	   return films;
   }
   
}
