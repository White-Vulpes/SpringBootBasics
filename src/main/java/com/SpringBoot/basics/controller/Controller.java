package com.SpringBoot.basics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.basics.Loads.Loads;
import com.SpringBoot.basics.Services.Services;

@RestController
public class Controller {
	
	@Autowired 
	Services service;

	@GetMapping("/load")
	public List<Loads> load() {
		return service.getAll();
	}
	
	@GetMapping("/load/{loadId}")
	public Loads loadwithID(@PathVariable String loadId) {
		return service.getWithId(loadId);
	}
	
	@PostMapping("/load")
	public String postLoad(@RequestBody Loads loads) {
		return service.addData(loads);
	}
	
	@PutMapping("/load")
	public String putLoadwithID(@RequestBody Loads loads) {
		return service.editLoad(loads);
	}
	
	@DeleteMapping("/load/{loadId}")
	public String deleteLoadwithID(@PathVariable String loadId) {
		return service.delete(loadId);
	}
}
