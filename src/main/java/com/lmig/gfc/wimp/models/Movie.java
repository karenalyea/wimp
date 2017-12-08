package com.lmig.gfc.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="movie")
public class Movie {
	
	
	
	@ManyToMany(mappedBy = "movies") // anything added to this collection and saved DOES NOT go to the database
	private List<Actor> actors;
	
	@Id
	@GeneratedValue(generator = "movie_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_id_seq", sequenceName = "movie_id_seq")
	private Long id;
		
	@Column(length=300, nullable=false)
	private String title;
	
	@Column(nullable=true)
	private Date releaseDate;
	
	@Column(nullable=true)
	private Long budget;
	
	@Column(nullable=false, length=500)
	private String distributor;
	 
	public Movie() {}
	public Movie(String title, Date releaseDate, Long budget, String distributor) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.distributor = distributor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}
