package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PropertyType;
import com.example.demo.service.PropertyTypeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PropertyTypeController {

	@Autowired
	PropertyTypeService propertyTypeService;

	@GetMapping("/propertType")
	public List<PropertyType> getPropertyType() {
		return propertyTypeService.getPropertyType();
	}

	@PostMapping("/propertType")
	public ResponseEntity<PropertyType> addProduct(@RequestBody PropertyType propertyType) {
		PropertyType p = propertyTypeService.addPropertyType(propertyType);
		return new ResponseEntity<PropertyType>(p, HttpStatus.CREATED);

	}

	@GetMapping("/propertType/{propertyTypeId}")
	public ResponseEntity<PropertyType> getProperty(@PathVariable String propertyTypeId) {

		if (propertyTypeService.getPropertyTypeById(propertyTypeId) != null) {
			return new ResponseEntity<PropertyType>(propertyTypeService.getPropertyTypeById(propertyTypeId),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<PropertyType>(new PropertyType(), HttpStatus.NOT_FOUND);
		}
	}

}
