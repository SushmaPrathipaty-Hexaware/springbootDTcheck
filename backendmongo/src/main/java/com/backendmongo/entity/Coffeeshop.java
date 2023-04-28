package com.backendmongo.entity;

import javax.persistence.Id;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coffeeshop")
public class Coffeeshop {

	@Id
	private String id;
    private String name;
    private Double price;
    private Date availability;
    private Boolean check;

	public Coffeeshop(String id, 
        String name, 
        Double price, 
        Date availability, 
        Boolean check
    ){
    this.id = id;
	this.name = name;
	this.price = price;
	this.availability = availability;
	this.check = check;
	}

    public Coffeeshop(){}
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
        return "[id = " + this.id +
                "name = " + this.name +
                "price = " + this.price +
                "availability = " + this.availability +
                "check = " + this.check +
            "]";
    }

}
