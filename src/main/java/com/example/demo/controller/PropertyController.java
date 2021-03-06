package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@GetMapping("/properties")
	public List<Property> getAllProperties() {
		return propertyService.getAllProperties();
	}

	@GetMapping("/properties/{propertyId}")
	public ResponseEntity<Property> getProperty(@PathVariable String propertyId) {

		if (propertyService.getProperty(propertyId) != null) {
			return new ResponseEntity<Property>(propertyService.getProperty(propertyId), HttpStatus.OK);
		} else {
			return new ResponseEntity<Property>(new Property(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/properties/bestSeller")
	public List<Property> getBestSellerProperties() {
		if (propertyService.findByBestSeller() != null) {
			return propertyService.findByBestSeller();
		} else
			return null;
	}

	@DeleteMapping("/properties/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable String propertyId) {

		if (propertyService.getProperty(propertyId) != null) {
			propertyService.deleteProperty(propertyId);
			return new ResponseEntity<String>("property deleted: " + propertyId, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Property with this Id exists: " + propertyId, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/properties/type/{title}")
	public ResponseEntity<List<Property>> getPropertyByTitle(@PathVariable String title) {

		return new ResponseEntity<List<Property>>(propertyService.getPropertyByTitle(title), HttpStatus.OK);

	}

	@PostMapping("/properties")
	public ResponseEntity<Property> addProduct(@RequestBody Property property) {
		Property p = propertyService.addProperty(property);
		return new ResponseEntity<Property>(p, HttpStatus.CREATED);

	}

	@PutMapping("/properties/{propertyId}")
	public ResponseEntity<Property> updateProduct(@RequestBody Property property, @PathVariable String propertyId) {

		property.setId(propertyId);
		Property p = propertyService.getProperty(propertyId);
		Property pro = propertyService.addProperty(property);
		if (null != p) {

			return new ResponseEntity<Property>(pro, HttpStatus.OK);

		} else {

			return new ResponseEntity<Property>(pro, HttpStatus.CREATED);
		}

	}

}
