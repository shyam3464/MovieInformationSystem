/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.model;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

public class Movie{
	
	private String name;
	private String director;
	private String productionHouse;
	private String genre;
	private String actor;
	private BigDecimal rating;
	private String budget;
	private String collections;
	private Time duration;
	@DateTimeFormat(pattern = "mmDDyyyy")
	private Date releaseDate;
	private int movieId;
	private int actorId;
	private int genreId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProductionHouse() {
		return productionHouse;
	}
	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getCollections() {
		return collections;
	}
	public void setCollections(String collections) {
		this.collections = collections;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	
}