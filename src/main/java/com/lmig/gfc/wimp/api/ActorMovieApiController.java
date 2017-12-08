package com.lmig.gfc.wimp.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movies/{movieId}/actors")
public class ActorMovieApiController {

	private ActorRepository actorRepository;
	private MovieRepository movieRepository;

	public ActorMovieApiController(ActorRepository actorRepository, MovieRepository movieRepository) {
		this.actorRepository = actorRepository;
		this.movieRepository = movieRepository;

	}

	@PostMapping("")
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {
		Movie movie = movieRepository.findOne(movieId);
		Actor actor = actorRepository.findOne(actorId);

		if (!movie.getActors().contains(actor)) {
			// You need to use actor.getMovies().add(movie)
			// and save the actor, instead. Because, the variable
			// "movies" in the class Actor DOES NOT have the "mappedBy"

			actor.getMovies().add(movie);

			actorRepository.save(actor);
		}

		return movie;

	}

}
