package com.palash.investment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pkn_app_modules")
public class ModuleModel extends MasterModel implements Serializable{

	private static final long serialVersionUID = 4116302974831027539L;
	@Column(name = "module_name")
	private String moduleName;
	@Column(name = "module_purpose")
	private String modulePurpose;
	
	public ModuleModel() {
	}
	public String getModuleName() {
		return this.moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModulePurpose() {
		return this.modulePurpose;
	}
	public void setModulePurpose(String modulePurpose) {
		this.modulePurpose = modulePurpose;
	}
	@Override
	public String toString() {
		return "ModuleModel [moduleName=" + this.moduleName + ", modulePurpose=" + this.modulePurpose + "]";
	}
	
	
}
