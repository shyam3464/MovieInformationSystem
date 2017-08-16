/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.dao;

import java.util.List;

import com.ethicalprogrammers.mis.model.Movie;

public interface MovieDao {
	
	public boolean createMovie(Movie movie);

	public int getGenreIdByName(String genre);
	
	public Movie getMovieInfo(Movie movie);
	
	public List<Movie> getMovieList(Movie movie);

}
