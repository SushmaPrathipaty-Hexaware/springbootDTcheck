package com.backendmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backendmongo.entity.Coffeeshop;

@Repository
public interface CoffeeshopRepository extends MongoRepository<Coffeeshop, String> {
  
}