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

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actors")

public class ActorsApiController {
	
	private ActorRepository actorRepository;

	public ActorsApiController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepository.findAll();
	}
	
	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepository.save(actor);
	}
	
	@GetMapping({"id"})
	public Actor getOne(@PathVariable Long id) {
		return actorRepository.findOne(id);
	}
	
	@PutMapping({"id"})
	public Actor update(@RequestBody Actor movie, @PathVariable Long id) {
		return actorRepository.save(movie);
	}
	
	
	@DeleteMapping({"id"})
	public Actor delete(@PathVariable Long id) {
		Actor actor = actorRepository.findOne(id);
		actorRepository.delete(id);
		return actor;
	}

}
