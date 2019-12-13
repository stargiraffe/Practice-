package com.example.demo.model;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product{ 
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	private int price;
	
	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		System.out.println("dddddddddddddddddddddddddddddddddddddd");
		return id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param price
	 */
	public void setPrice(final int price){
		this.price = price;
	}

	/**
	 * 
	 * @return the price
	 */
	public int getPrice(){
		return price;
	}

}