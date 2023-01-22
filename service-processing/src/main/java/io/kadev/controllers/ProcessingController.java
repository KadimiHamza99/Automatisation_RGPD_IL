package io.kadev.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.kadev.dto.Actor;
import io.kadev.dto.DataSubject;
import io.kadev.dto.ProcessingApiResponse;
import io.kadev.models.Processing;
import io.kadev.services.ProcessingServiceInterface;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/processing")
@AllArgsConstructor
public class ProcessingController {
	
	@Autowired
	ProcessingServiceInterface service;
	@Autowired
	RestTemplate template;
	
	
	@PostMapping("/create")
	public Processing newProcessing(Processing processing) {
		return service.createProcessing(processing);
	}
	
	@PutMapping("/update")
	public Processing modifyProcessing(Processing processing) {
		return service.updateProcessing(processing);
	}
	
	@GetMapping("/{id}")
	public ProcessingApiResponse getProcessing(@PathVariable Long id) {
		Processing processing = service.getProcessing(id);
		List<Actor> actors = new ArrayList<Actor>();
		processing.getActorsId().stream().forEach(actorId->{
			Actor actor = template.getForObject("http://localhost:8080/express/dataSubject/getById/"+actorId, 
					DataSubject.class);
			actors.add(actor);
		});
		ProcessingApiResponse response = new ProcessingApiResponse(actors, processing);
		return response;
	}
	
	@GetMapping("")
	public Collection<ProcessingApiResponse> getProcessings(){
		Collection<ProcessingApiResponse> response = new ArrayList<ProcessingApiResponse>();
		service.getProcessings().stream().forEach(processing->{
			List<Actor> actors = new ArrayList<Actor>();
			processing.getActorsId().stream().forEach(actorId->{
				Actor actor = template.getForObject("http://localhost:8080/express/dataSubject/getById/"+actorId, 
						DataSubject.class);
				actors.add(actor);
			});
			response.add(new ProcessingApiResponse(actors,processing));
		});
		return response;
	}
}
