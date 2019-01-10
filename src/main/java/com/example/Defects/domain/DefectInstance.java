package com.example.Defects.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class DefectInstance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Auto;
	private long id_log;
	
	public DefectInstance() {
		super();
	}
	
	  @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "app")
      private App app;
	  @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "def")
      private Defect def;
	  @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "file")
      private LogFile file;
	  
	    
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		@JsonIgnore
      public DefectInstance(  long id_log, App app, Defect def, LogFile logfile) {
		super();
	
		this.id_log = id_log;
		this.app = app;
		this.def = def;
		this.file = logfile;
	}

	public DefectInstance( long id_log, App app, Defect def) {
		super();
	
		this.id_log = id_log;
		this.app = app;
		this.def = def;
	}

	public DefectInstance(long id_log, App app) {
		super();
		this.id_log = id_log;
		this.app = app;
	}

	//Getter and setter
      public App getOwner() {
        return app;
      }

      public void setOwner(App app) {
        this.app = app;
      }
	public long getId_Auto() {
		return id_Auto;
	}
	public void setId_Auto(long id_Auto) {
		this.id_Auto = id_Auto;
	}
	

	public long getId_log() {
		return id_log;
	}
	public void setId_log(long id_log) {
		this.id_log = id_log;
	}
	
	
	

}
