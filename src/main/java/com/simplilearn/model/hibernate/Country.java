package com.simplilearn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "countryCode")
	private String countryCode;
	
	@Column(name = "countryName")
	private String countryName;
	
	@Column(name = "population")
	private long population;
	

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(int id, String countryCode, String countryName, long population) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.population = population;
	}
	public Country(String countryCode, String countryName, long population) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.population = population;
	}
	public Country(int id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName + ", population="
				+ population + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}	
	
}
