package com.example.Defects.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Solutions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name_solution,description;
	public Solutions() {
		super();
	}
	
	  @OneToMany(cascade = CascadeType.ALL, mappedBy="sol")
	    private List<Defect> defect;
	public Solutions( String name_solution, String description) {
		super();
		this.name_solution = name_solution;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName_solution() {
		return name_solution;
	}
	public void setName_solution(String name_solution) {
		this.name_solution = name_solution;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
