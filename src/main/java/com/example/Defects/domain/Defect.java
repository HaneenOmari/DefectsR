package com.example.Defects.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Defect {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private long Def_id;
	private String severity,error_code;
	private String id_sol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="def")
    private List<DefectInstance> defectsInctanse;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sol")
    private Solutions sol;
    
    public Defect(String severity, String error_code, String id_sol,Solutions sol) {
		super();
		this.severity = severity;
		this.error_code = error_code;
		this.id_sol = id_sol;
		this.defectsInctanse = defectsInctanse;
		this.sol = sol;
	}

	public Defect( String severity, String error_code, String id_sol,List<DefectInstance> defectsInctanse) {
		super();
		
		this.severity = severity;
		this.error_code = error_code;
		this.id_sol = id_sol;
		this.defectsInctanse = defectsInctanse;
	}

	//Getter and setter
    public List<DefectInstance> getdefectsInctanse() {
      return defectsInctanse;
    }

    public void setdefectsInctanse(List<DefectInstance> defectsinctanse) {
      this.defectsInctanse = defectsinctanse;
    }
	public Defect(String severity, String error_code, String id_sol) {
		super();
		this.severity = severity;
		this.error_code = error_code;
		this.id_sol = id_sol;
	}
	
	public Defect() {
		
	}

	public long getDef_id() {
		return Def_id;
	}

	public void setDef_id(long def_id) {
		Def_id = def_id;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getId_sol() {
		return id_sol;
	}

	public void setId_sol(String id_sol) {
		this.id_sol = id_sol;
	}


}
