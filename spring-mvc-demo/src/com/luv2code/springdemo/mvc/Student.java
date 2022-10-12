package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private String[] operatingSystems;
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("USA", "USA");
		countryOptions.put("UK", "United Kingdom");
		countryOptions.put("RO", "Romania");
		countryOptions.put("FR", "France");
		
		favoriteLanguageOptions = new LinkedHashMap<>();
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("C++", "C++");
		favoriteLanguageOptions.put("C", "C");
		favoriteLanguageOptions.put("Java", "Java");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
	
	
	
	
}
