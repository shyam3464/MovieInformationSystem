/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.service;

import com.ethicalprogrammers.mis.model.Movie;

public interface AdministratorService {
	
	public boolean addMovie(Movie movie);

	public void deleteMovie(Movie movie);

}
