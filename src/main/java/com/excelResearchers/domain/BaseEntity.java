package com.excelResearchers.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

public abstract class BaseEntity {
	@Id
	@Property("id")
	protected ObjectId id;

	public String getId() {
		return this.id.toString();
	}

	public void setId(String id) {
		this.id = new ObjectId(id);
	}
}
