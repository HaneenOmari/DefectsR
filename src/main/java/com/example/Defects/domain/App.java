package com.example.Defects.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class App {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name,type;
	public App() {
		
	}

    @OneToMany(cascade = CascadeType.ALL, mappedBy="app")
    private List<DefectInstance> defectsInctanse;
    
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	
	
    //Getter and setter
    public List<DefectInstance> getdefectsInctanse() {
      return defectsInctanse;
    }

    public void setdefectsInctanse(List<DefectInstance> defectsinctanse) {
      this.defectsInctanse = defectsinctanse;
    }

	public App(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public long getId() {
		return id;	}

//	public void setId(String id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
