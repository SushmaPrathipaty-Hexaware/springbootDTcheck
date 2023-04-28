
package com.backendmysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.backendmysql.entity.Coffeeshop;
import com.backendmysql.exception.EntityNotFoundException;
import com.backendmysql.repository.CoffeeshopRepository;
import com.backendmysql.dto.CoffeeshopDto;

@Service
public class CoffeeshopService {

	@Autowired
	private CoffeeshopRepository coffeeshopRepo;

	public Coffeeshop fetchById(final Long id) {
		Optional<Coffeeshop> coffeeshop = coffeeshopRepo.findById(id);
		if (!coffeeshop.isPresent()) {
			throw new EntityNotFoundException("id-" + id);
		}
		return coffeeshop.get();
	}

	public List<Coffeeshop> fetchAll() {
		return coffeeshopRepo.findAll();
	}

	public Coffeeshop create(final CoffeeshopDto coffeeshopDto) {
		Coffeeshop coffeeshop = new Coffeeshop();
			coffeeshop.setName(coffeeshopDto.getName());			coffeeshop.setPrice(coffeeshopDto.getPrice());			coffeeshop.setAvailability(coffeeshopDto.getAvailability());			coffeeshop.setCheck(coffeeshopDto.getCheck());		return coffeeshopRepo.save(coffeeshop);
	}

	public ResponseEntity<Object> update(final CoffeeshopDto coffeeshopDto, final Long id) {
		
		Optional<Coffeeshop> coffeeshopOptional = coffeeshopRepo.findById(id);
		if (!coffeeshopOptional.isPresent()) {
			throw new EntityNotFoundException("id-" + id);
		}
		Coffeeshop coffeeshop = coffeeshopOptional.get();
			coffeeshop.setName(coffeeshopDto.getName());			coffeeshop.setPrice(coffeeshopDto.getPrice());			coffeeshop.setAvailability(coffeeshopDto.getAvailability());			coffeeshop.setCheck(coffeeshopDto.getCheck());		coffeeshopRepo.save(coffeeshop);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	public void delete(final Long id) {
		coffeeshopRepo.deleteById(id);
	}

}
