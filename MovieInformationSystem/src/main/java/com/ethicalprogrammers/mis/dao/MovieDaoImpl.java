/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ethicalprogrammers.mis.model.Movie;

public class MovieDaoImpl implements MovieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean createMovie(Movie movie) {
		int numRows = 0;
		String insertQuery = "insert into MOVIE ( MOVIE_NAME, DIRECTOR, PRODUCTION_HOUSE , GENRE_ID, RELEASE_DATE) values ( ?, ?, ?, ?, ?) ";
		Object[] params = new Object[] { movie.getName(), movie.getDirector(),
				movie.getProductionHouse(), movie.getGenreId(),
				movie.getReleaseDate() };
		numRows = jdbcTemplate.update(insertQuery, params);
		return numRows == 1 ? true : false;
	}

	@Override
	public Movie getMovieInfo(Movie movie) {
		Movie storedMovieInfo = null;
		try {
			storedMovieInfo = (Movie) jdbcTemplate
				.queryForObject(
						"SELECT * FROM MOVIE WHERE MOVIE_NAME = ? AND GENRE_ID = ? AND RELEASE_DATE = ? ",  new MovieRowMapper(),
						movie.getName(), movie.getGenreId(),
						movie.getReleaseDate());
		} catch (EmptyResultDataAccessException e) {
			
		}
		return storedMovieInfo;
	}

	@Override
	public int getGenreIdByName(String genreName) {
		int genreId = 0;
		try {
			genreId = jdbcTemplate.queryForInt(
					"SELECT GENRE_ID FROM GENRE where GENRE_NAME = ?",
					genreName);
		} catch (EmptyResultDataAccessException e) {

		}
		return genreId;
	}
	
	private String getCompleteSql(Movie movie, String sql) {
		
		if (movie.getName() != null && !movie.getName().isEmpty()) {
			sql = sql + " AND MOVIE_NAME LIKE" + "'" + movie.getName() + "%'";
		}
		
		if (movie.getReleaseDate() != null) {
			sql = sql + " AND RELEASE_DATE LIKE" + "'" + movie.getReleaseDate() + "'";
		}
		
		if (movie.getGenre() != null && !movie.getGenre().isEmpty()) {
			int genreId =0;
			genreId = getGenreIdByName(movie.getGenre());
			if (genreId != 0 ) {
				sql = sql + " AND GENRE_ID =" + genreId;
			}
		} 
		
	
		if (movie.getDirector() != null && !movie.getDirector().isEmpty()) {
			sql = sql + " AND DIRECTOR LIKE" + "'" + movie.getDirector() + "%'";
		} 
	

		if (movie.getProductionHouse() != null && !movie.getProductionHouse().isEmpty()) {
			sql = sql + " AND PRODUCTION_HOUSE LIKE" + "'" + movie.getProductionHouse() + "%'";
		} 
		return sql;
	}
	
	@Override
	public List<Movie> getMovieList(Movie movie) {
		String sql = "SELECT * FROM MOVIE WHERE MOVIE_ID  LIKE '%' ";
		
		sql = getCompleteSql(movie, sql);
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			movieList = jdbcTemplate.query(sql, new MovieRowMapper());
			
		} catch (EmptyResultDataAccessException e) {
			
		}
		return movieList;
	}


	public class MovieRowMapper implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Movie obj = new Movie();
			obj.setActorId(resultSet.getInt("LEAD_ACTOR_ID"));
			obj.setBudget(resultSet.getString("BUDGET"));
			obj.setCollections(resultSet.getString("COLLECTIONS"));
			obj.setDirector(resultSet.getString("DIRECTOR"));
			obj.setGenreId(resultSet.getInt("GENRE_ID"));
			obj.setMovieId(resultSet.getInt("MOVIE_ID"));
			obj.setName(resultSet.getString("MOVIE_NAME"));
			obj.setProductionHouse(resultSet.getString("PRODUCTION_HOUSE"));
			obj.setRating(resultSet.getBigDecimal("MOVIE_RATING"));
			obj.setReleaseDate(resultSet.getDate("RELEASE_DATE"));
			obj.setDuration(resultSet.getTime("DURATION"));
			return obj;
		}

	}
}
