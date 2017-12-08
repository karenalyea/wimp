package com.lmig.gfc.wimp.config;


import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepository, MovieRepository movieRepository, AwardRepository awardRepository) {
		Actor joe = actorRepository.save(new Actor("Joe", "Star", 2015L, null));
		movieRepository.save(new Movie("Gone with the Wind", null, null, "MGM"));
		Actor betty = actorRepository.save(new Actor("Betty", "Boop", 1911L, null));
		movieRepository.save(new Movie("Big", null, null, "Paramont"));
		movieRepository.save(new Movie("Four Rooms", null, 4000000L, "Mirimax Films"));
		actorRepository.save(new Actor("Tim", "Roth", 1982L, null));
		awardRepository.save(new Award("Best Actor", "BAFTA", 1982, joe));
		awardRepository.save(new Award("Worst Movie", "Raspberries", 2017, betty));
	}
}
