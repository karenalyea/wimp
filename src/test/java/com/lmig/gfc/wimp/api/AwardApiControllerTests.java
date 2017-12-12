package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;

public class AwardApiControllerTests {

	private AwardApiController controller;
	@Mock private AwardRepository awardRepo;
	@Mock private ActorRepository actorRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new AwardApiController(actorRepo, awardRepo); 
			
		}
		
		@Test
		public void create_saves_actor_when_there_is_no_award() {
			//Arrange
			Actor actor = new Actor();
			actor.setAwards(new ArrayList<Award>());
			Award award = new Award();
			when(actorRepo.findOne(15L)).thenReturn(actor);
			when(awardRepo.findOne(2L)).thenReturn(award);
			
			//Act
			Actor actual = controller.create(15L, 2L);
			
			//Assert
			assertThat(actual).isSameAs(actor);
			verify(actorRepo).save(actor);
			assertThat(actor.getAwards()).contains(award);
			verify(actorRepo).findOne(15L);
			verify(awardRepo).findOne(2L);

			
		}
		
		@Test
		public void create_does_not_save_actor_if_award_is_already_there() {
			//Arrange
			Award award = new Award();
			ArrayList<Award> awards = new ArrayList<Award>();
			awards.add(award);
			Actor actor = new Actor();
			actor.setAwards(awards);
			when(actorRepo.findOne(15L)).thenReturn(actor);
			when(awardRepo.findOne(2L)).thenReturn(award);
			
			//Act
			Actor actual = controller.create(15L, 2L);
			
			//Assert
			verify(awardRepo).findOne(2L);
			verify(actorRepo).findOne(15L);
			assertThat(actual).isSameAs(actor);
			verify(actorRepo, never()).save(actor);	
			
		}
	}

