/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ethicalprogrammers.mis.dao.MovieDao;
import com.ethicalprogrammers.mis.model.Movie;

public class AdministratorServiceImpl implements AdministratorService {
	
	@Autowired
	private MovieDao movieDao;

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	public boolean addMovie(Movie movie) {
		boolean success = false;
		Movie movieInfo = null;
		int genreId = movieDao.getGenreIdByName(movie.getGenre());
		if(genreId !=0) {
			movie.setGenreId(genreId);
		} else {
			//
		}
		movieInfo = movieDao.getMovieInfo(movie);
		if (null == movieInfo) {
			success = movieDao.createMovie(movie);
		} 
		return success;
	}

	public void deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

}
