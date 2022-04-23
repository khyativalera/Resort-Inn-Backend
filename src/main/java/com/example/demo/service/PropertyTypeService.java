package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PropertyType;
import com.example.demo.repository.PropertyTypeDao;

@Service
public class PropertyTypeService {

	@Autowired
	PropertyTypeDao propertyTypeDao;

	public List<PropertyType> getPropertyType() {
		// TODO Auto-generated method stub
		return propertyTypeDao.findAll();
	}

	public PropertyType addPropertyType(PropertyType propertyType) {
		// TODO Auto-generated method stub
		return propertyTypeDao.save(propertyType);
	}

	public PropertyType getPropertyTypeById(String propertyTypeId) {
		// TODO Auto-generated method stub
		Optional<PropertyType> property = propertyTypeDao.findById(propertyTypeId);
		if (property.isPresent()) {
			return property.get();
		} else {
			return null;
		}
	}

}
