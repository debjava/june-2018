package com.ddlab.rnd.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"id","name"})
public class Employee {
	
	@JsonProperty
	private String id;
	@JsonProperty
	private String name;
}
