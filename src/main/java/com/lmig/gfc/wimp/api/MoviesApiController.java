package com.lmig.gfc.wimp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movie")
public class MoviesApiController {
	
	private MovieRepository movieRepository;
	
	public MoviesApiController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("")
	public List<Movie> getAll(){
		return movieRepository.findAll();
	}
	
	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@GetMapping({"id"})
	public Movie getOne(@PathVariable Long id) {
		return movieRepository.findOne(id);
	}
	
	@PutMapping({"id"})
	public Movie update(@RequestBody Movie movie, @PathVariable Long id) {
		return movieRepository.save(movie);
	}
	
	@DeleteMapping({"id"})
	public Movie delete(@PathVariable Long id) {
		Movie movie = movieRepository.findOne(id);
		movieRepository.delete(id);
		return movie;
	}
	

}
