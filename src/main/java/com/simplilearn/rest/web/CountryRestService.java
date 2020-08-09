package com.simplilearn.rest.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.simplilearn.dao.CountryDAO;
import com.simplilearn.model.hibernate.Country;

@Path("/managecountries")
public class CountryRestService {

	CountryDAO countryDAO = new CountryDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getAllCountries() {
		return countryDAO.getAllCountries();
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		return countryDAO.addCountry(country);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countryDAO.updateCountry(country);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		countryDAO.deleteCountry(id);
	}

}
