package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.MovieRepository;

public class MoviesApiControllerTests {
	
	private MoviesApiController controller;
	private MovieRepository repo;
	
	@Before
	public void setup() {
		repo = mock(MovieRepository.class);
		controller = new MoviesApiController(repo);
	}
	
	@Test
	public void get_all_movie_records() {
		//Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		when(repo.findAll()).thenReturn(movies);
		
		//Act
		List<Movie> actual = controller.getAll();
		
		//Assert
		assertThat(actual).isSameAs(movies);
		verify(repo).findAll();
		
	}
	
	@Test
	public void create_a_new_movie() {
		//Arrange
		
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);
		
		//Act
		Movie actual = controller.create(movie);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);
	}
	
	@Test
	public void getOne_returns_a_movie_for_a_valid_id() {
		//Arrange
		Movie movie = new Movie();
		when(repo.findOne(5L)).thenReturn(movie);
		
		//Act
		Movie actual = controller.getOne(5L);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(5L);
		
	}
	
	@Test
	public void getOne_returns_a_dog_for_an_invalid_id() {
		//Arrange
		
		//Act
		Movie actual = controller.getOne(5L);
		
		//Assert
		assertThat(actual).isNull();
		verify(repo).findOne(5L);
	}
	@Test
	public void update_sets_id_of_movie_and_calls_save_and_return() {
		//Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);
		
		//Act
		Movie actual = controller.update(movie, 5L);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);
		assertThat(movie.getId()).isEqualTo(5L);
	}
	
	@Test
	public void delete_get_the_movie_returns_it() {
		//Arrange
		Movie movie = new Movie();
		when(repo.findOne(5L)).thenReturn(movie);
		
		//Act
		
		Movie actual = controller.delete(5L);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(5L);
		verify(repo).delete(5L);
	}
	
}
