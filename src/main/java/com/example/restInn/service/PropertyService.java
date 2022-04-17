package com.example.restInn.service;

import com.example.restInn.entity.Property;
import com.example.restInn.repository.PropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
	
	@Autowired
	PropertyDao propertyDao;
	
	public List<Property> getAllProperties(){
		return propertyDao.findAll();
	}
	
	public Property getProperty(String propertyId) {
		Optional<Property> property= propertyDao.findById(propertyId);
		if(property.isPresent()) {
			return property.get();
		}else {
			return null;
		}
	}
	public void deleteProperty(String propertyId) {
		propertyDao.deleteById(propertyId);
	}
	public List<Property> getPropertyByTitle(String title){
		List<Property> property = new ArrayList<>();
		for(Property p: propertyDao.findAll())
		{
			if(p.getTitle().equals(title) || p.getType().equals(title)) {
				property.add(p);
			}
		}
		return property;
	}

	public Property addProperty(Property property) {
		return propertyDao.save(property);
	}


	public List<Property> findByBestSeller() {

		return propertyDao.findByBestSeller();

	}
}
