package com.lmig.gfc.wimp.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepository, MovieRepository movieRepository) {
		actorRepository.save(new Actor("Joe", "Star", 2015L, null));
		movieRepository.save(new Movie("Gone with the Wind", null, null, "MGM"));
		actorRepository.save(new Actor("Betty", "Boop", 1911L, null));
		movieRepository.save(new Movie("Big", null, null, "Paramont"));
	}
}
