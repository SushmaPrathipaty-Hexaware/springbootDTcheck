package com.backendmysql.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import com.backendmysql.entity.Coffeeshop;
import com.backendmysql.service.CoffeeshopService;
import com.backendmysql.dto.CoffeeshopDto;

@RestController
public class CoffeeshopController {

	@Autowired
	private CoffeeshopService coffeeshopService;
	@GetMapping("/coffeeshop")
	public List<Coffeeshop> fetchAll() {
		return this.coffeeshopService.fetchAll();
	}

	@GetMapping("/Coffeeshop/{id}")
	public Coffeeshop fetchById(@PathVariable Long id) {
		return this.coffeeshopService.fetchById(id);
	}

	@DeleteMapping("/coffeeshop/{id}")
	public void delete(@PathVariable Long id) {
		this.coffeeshopService.delete(id);
	}

	@PostMapping("/coffeeshop")
	public Coffeeshop create(@Valid @RequestBody CoffeeshopDto coffeeshopDto) {
		
		return this.coffeeshopService.create(coffeeshopDto);
	}
	
	@PutMapping("/coffeeshop/{id}")
	public ResponseEntity<Object> update(@Valid @RequestBody CoffeeshopDto coffeeshopDto, @PathVariable Long id) {	
		return this.coffeeshopService.update(coffeeshopDto, id);
	}
}