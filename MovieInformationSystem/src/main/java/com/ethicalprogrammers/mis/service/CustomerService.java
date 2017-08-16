/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.service;

import java.util.List;

import com.ethicalprogrammers.mis.model.Movie;

public interface CustomerService {
	public List<Movie> searchMovie(Movie movie);

}
