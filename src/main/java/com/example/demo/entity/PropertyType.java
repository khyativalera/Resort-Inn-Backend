package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("PropertyType")
public class PropertyType {
	
	@Id
	private String id;
	private String type;
	private String img;
	
	
	
	public PropertyType(String id, String type, String img) {
		super();
		this.id = id;
		this.type = type;
		this.img = img;
	}

	public PropertyType() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	

}
