package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

public class ActorMovieApiControllerTests {
	private ActorMovieApiController controller;
	@Mock private ActorRepository actorRepo;
	@Mock private MovieRepository movieRepo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new ActorMovieApiController(actorRepo, movieRepo);			
		}
	
	@Test
	public void create_save_movie_with_new_actor() {
	//Arrange
	Actor actor = new Actor();
	Movie movie = new Movie();
	movie.setActors(new ArrayList<Actor>());
	actor.setMovies(new ArrayList<Movie>());
	
	when(actorRepo.findOne(2L)).thenReturn(actor);
	when(movieRepo.findOne(1L)).thenReturn(movie);
	
	//Act
	Movie actual = controller.create(1L, 2L);
	
	//Assert
	assertThat(actual).isSameAs(movie);
	verify(actorRepo).save(actor);
	assertThat(actor.getMovies()).contains(movie);
	verify(actorRepo).findOne(2L);
	verify(movieRepo).findOne(1L);
	
	}
	
	
	}


