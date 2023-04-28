package com.backendmssql.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CoffeeshopDto {

    private String name;
    private Double price;
    private Date availability;
    private Boolean check;

    public CoffeeshopDto(){}

	public CoffeeshopDto( 
        String name, 
        Double price, 
        Date availability, 
        Boolean check
    ){
	this.name = name;
	this.price = price;
	this.availability = availability;
	this.check = check;
	}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return this.price;
    }
    public void setAvailability(Date availability){
        this.availability = availability;
    }

    public Date getAvailability(){
        return this.availability;
    }
    public void setCheck(Boolean check){
        this.check = check;
    }

    public Boolean getCheck(){
        return this.check;
    }

    public String toString(){
        return "[" + 
                "name = " + this.name +
                "price = " + this.price +
                "availability = " + this.availability +
                "check = " + this.check +
            "]";
    }

}
