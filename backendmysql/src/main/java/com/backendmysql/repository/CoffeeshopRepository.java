package com.backendmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendmysql.entity.Coffeeshop;

@Repository
public interface CoffeeshopRepository extends JpaRepository<Coffeeshop, Long> {
  
}
