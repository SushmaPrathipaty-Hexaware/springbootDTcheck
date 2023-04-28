package com.backendmongo.dto;

import java.util.Date;

public class CoffeeshopDto {

    private String name;
    private Double price;
    private Date availability;
    private Boolean check;

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

    public CoffeeshopDto(){}
    
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
