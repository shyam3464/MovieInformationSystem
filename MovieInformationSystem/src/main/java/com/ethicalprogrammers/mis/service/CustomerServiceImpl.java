package com.ethicalprogrammers.mis.service;

import java.util.List;

import com.ethicalprogrammers.mis.dao.MovieDao;
import com.ethicalprogrammers.mis.model.Movie;

public class CustomerServiceImpl implements CustomerService {
	
	private MovieDao movieDao;
	
	

	public MovieDao getMovieDao() {
		return movieDao;
	}



	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}



	public List<Movie> searchMovie(Movie movie) {
		List<Movie> movieList = movieDao.getMovieList(movie);
		return movieList;
	}

}
