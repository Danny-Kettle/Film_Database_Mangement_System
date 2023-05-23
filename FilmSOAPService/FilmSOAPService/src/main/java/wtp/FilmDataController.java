package wtp;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.xml.transform.stream.StreamSource;

import com.google.gson.Gson;
import db.FilmDAO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.Film;
import model.FilmList;


public class FilmDataController {
	Gson gson = new Gson();
	FilmDAO dao = new FilmDAO();
	ArrayList<Film> allFilms = new ArrayList<Film>();
	
	//Add Film
	public String addFilmData(String title, int year, String director, String stars, String review ) {
    	Film lastFilm = dao.getLastFilm(dao.getAllFilms());
    	
    	System.out.println(lastFilm.getId());
    	
    	int id = (lastFilm.getId() + 1);
    	Film f = new Film(id,title,year,director,stars,review);
    	
    	try{
    		dao.insertFilm(f);
    		return "Film inserted";
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return "Could Not Insert Film";
	}
	
	
	//Delete Film
	public String deleteFilmData(int id) {
		Film f = dao.getFilmByID(id);
		
    	try{
    		dao.deleteFilm(f);
    		return "Film deleted";
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return "ID not recognised";
    	
	}
	
	
	//Update Film
	public String updateFilmData(int id, String title, int year, String director, String stars, String review) {
    	Film f = new Film(id,title,year,director,stars,review);
    	
      	try{
    		dao.updateFilm(f);
    		return "Film Updated";
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
      	
      	return "Could not find film to update";
	}
	
	
	
	//Get Film By Id
	public String getFilmByID(String format, int id){
		Film f = dao.getFilmByID(id);
		
		format = format.toLowerCase();
		
		switch(format) {
		case "json":
			Gson gson = new Gson();
			String json = gson.toJson(f);
			return json;
		case "xml":
			try {
				StringWriter sw = new StringWriter();

				JAXBContext context =
						JAXBContext.newInstance(Film.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						Boolean.TRUE);
				m.marshal(f, sw);
				return sw.toString();
			}
			catch(JAXBException ex) {
				System.out.println(ex.getMessage());
			}
			
			break;
		case "string":
			String str = f.toString();
			return str;
	}
		return "Format Not Supoport";
	}
	
	//Get All Films 
	public String getAllFilmData(String format) {
		ArrayList<Film> allFilms = new ArrayList<Film>();
		allFilms = dao.getAllFilms();
		
		format = format.toLowerCase();
		
		switch(format) {
		case "json":			
			Gson gson = new Gson();
			String json = gson.toJson(allFilms);
			return json;
		case "xml":
			try {
				StringWriter sw = new StringWriter();
				FilmList fl = new FilmList(allFilms);
				JAXBContext context =
						JAXBContext.newInstance(FilmList.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						Boolean.TRUE);
				m.marshal(fl, sw);
				return sw.toString();
			}
			catch(JAXBException ex) {
				System.out.println(ex.getMessage());
			}
			
			break;
		case "string":
			String str = "";
			for(Film f : allFilms) {
				str = str + f.toString();
			}
			
			return str;
	}
		return "Format Not Supported";
	}
	
	
	//Search Film
	public String searchFilmData(String searchStr ,String format) throws SQLException {
		ArrayList<Film> films = new ArrayList<Film>();
		films = dao.searchFilms(searchStr);
		
		format = format.toLowerCase();
		
		switch(format) {
		case "json":
			Gson gson = new Gson();
			String json = gson.toJson(films);
			return json;
		case "xml":
			try {
				FilmList fl = new FilmList(films);
				StringWriter sw = new StringWriter();
				JAXBContext context =
						JAXBContext.newInstance(FilmList.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						Boolean.TRUE);
				m.marshal(fl, sw);
				return sw.toString();
			}
			catch(JAXBException ex) {
				System.out.println(ex.getMessage());
			}
			
			break;
		case "string":
			String str = "";
			for(Film f : films) {
				str = str + f.toString();
			}
			return str;
	}
		return "Format Not Supoport";
	}
}
