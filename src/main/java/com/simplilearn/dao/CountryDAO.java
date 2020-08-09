package com.simplilearn.dao;

import java.util.List;
import org.hibernate.Session;
import com.simplilearn.model.hibernate.Country;
import com.simplilearn.model.hibernate.Department;
import com.simplilearn.utils.HibernateUtil;

@SuppressWarnings("unchecked")
public class CountryDAO {
	
	public List<Country> getAllCountries() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Country> countryList = session.createNamedQuery("HQL_GET_ALL_COUNTRIES").list();
		session.getTransaction().commit();
		session.close();
		return countryList;
	}
	
	public Country addCountry(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(country);
		session.getTransaction().commit();
		session.close();
		return country;
	}
	
	public Country updateCountry(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Country coun = session.get(Country.class, country.getId());
		coun.setCountryCode(country.getCountryCode());
		coun.setCountryName(country.getCountryName());
		session.getTransaction().commit();
		session.close();
		return country;
	}		
	
	public Country deleteCountry(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Country country = session.get(Country.class, id);
		session.delete(country);
		session.getTransaction().commit();
		session.close();
		return country;
	}	
	
}
