package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepository;

public class ActorsApiControllersTest {

	private ActorsApiController controller;
	private ActorRepository repo;
	private Actor actor;
	private List<Actor> actors;

	@Before
	public void setup() {
		repo = mock(ActorRepository.class);
		controller = new ActorsApiController(repo);
		actor = new Actor("Bill", "Williams", null, null);
		actors = new ArrayList<Actor>();
	}

	@Test
	public void getAll_returns_identical_lists() {
		// Arrange
		actors.add(actor);
		when(repo.findAll()).thenReturn(actors);

		// Act
		List<ActorView> actual = controller.getAll();

		// Assert
		assertThat(actual).hasSize(1);
		ActorView actorView = actual.get(0);
		assertThat(actorView.getFirstName()).isEqualTo("Bill");
		assertThat(actorView.getLastName()).isEqualTo("Williams");
		verify(repo).findAll();
	}

	@Test
	public void create_an_actor() {
		// Arrange
		when(repo.save(actor)).thenReturn(actor);

		// Act
		ActorView actual = controller.create(actor);

		// Assert
		assertThat(actual.getFirstName()).isEqualTo("Bill");
		assertThat(actual.getLastName()).isEqualTo("Williams");
		verify(repo).save(actor);
	}

	@Test
	public void getOne_returns_specific_actor() {
		// Arrange
		when(repo.findOne(0L)).thenReturn(actor);

		// Act
		ActorView actual = controller.getOne(0L);

		// Assert
		assertThat(actual.getFirstName()).isEqualTo("Bill");
		assertThat(actual.getLastName()).isEqualTo("Williams");
		verify(repo).findOne(0L);
	}
	
	@Test
	public void update_a_specific_actor() {
		//Arrange
		when(repo.findOne(0L)).thenReturn(actor);
		
		//Act
		ActorView actual = controller.update(actor, 0L);
		
		
		//Assert
		assertThat(actual.getFirstName()).isEqualTo("Bill");
		assertThat(actual.getLastName()).isEqualTo("Williams");
		verify(repo).save(actor);
				
	}
	
	@Test
	public void delete_an_actor_and_returns_it() {
		//Arrange
		Actor actor = new Actor();
		when(repo.findOne(0L)).thenReturn(actor);
		
		//Act
		ActorView actual = controller.delete(0L);
		
		//Assert
		assertThat(actual.getFirstName()).isEqualTo(null);
		assertThat(actual.getLastName()).isEqualTo(null);
		verify(repo).findOne(0L);
		verify(repo).delete(0L);
	}

}
