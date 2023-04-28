package com.backendmongo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backendmongo.entity.Coffeeshop;
import com.backendmongo.exception.EntityNotFoundException;
import com.backendmongo.repository.CoffeeshopRepository;
import com.backendmongo.dto.CoffeeshopDto;

@Service  
public class CoffeeshopService {

  @Autowired
  private CoffeeshopRepository coffeeshopRepo;

  public List<Coffeeshop> fetchAll() {
    return coffeeshopRepo.findAll();
  }

  public Coffeeshop fetchById(final String id) {
    Optional<Coffeeshop> coffeeshop = coffeeshopRepo.findById(id);

		if (!coffeeshop.isPresent()){
			throw new EntityNotFoundException("id-" + id);
    }
		return coffeeshop.get();
  }

  public void delete(final String id) {
    Optional<Coffeeshop> coffeeshop = coffeeshopRepo.findById(id);
    if(!coffeeshop.isPresent()){
      throw new EntityNotFoundException("Element not present");
    }
    else
    coffeeshopRepo.deleteById(id);
  }

  public Coffeeshop create(final CoffeeshopDto coffeeshopDto) {
    Coffeeshop coffeeshop = new Coffeeshop();
			coffeeshop.setName(coffeeshopDto.getName());
			coffeeshop.setPrice(coffeeshopDto.getPrice());
			coffeeshop.setAvailability(coffeeshopDto.getAvailability());
			coffeeshop.setCheck(coffeeshopDto.getCheck());
    return coffeeshopRepo.save(coffeeshop);
  }

  public ResponseEntity<Object> update(final CoffeeshopDto coffeeshopDto, final String id) {
    Optional<Coffeeshop> coffeeshopOptional = coffeeshopRepo.findById(id);
		if (!coffeeshopOptional.isPresent()) {
			return ResponseEntity.notFound().build();
    }
    Coffeeshop coffeeshop = coffeeshopOptional.get();
			coffeeshop.setName(coffeeshopDto.getName());
			coffeeshop.setPrice(coffeeshopDto.getPrice());
			coffeeshop.setAvailability(coffeeshopDto.getAvailability());
			coffeeshop.setCheck(coffeeshopDto.getCheck());
		coffeeshopRepo.save(coffeeshop);
		return ResponseEntity.noContent().build();
  }

}
