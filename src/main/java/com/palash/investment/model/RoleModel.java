package com.palash.investment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pkn_app_roles")
public class RoleModel  extends MasterModel implements Serializable{

	private static final long serialVersionUID = -6765982008333061748L;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_purpose")
	private String rolePurpose;
	
	@OneToMany(mappedBy = "roleModel")
	private List<UserModel> userList;
	
	public RoleModel() {
	}
	
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRolePurpose() {
		return this.rolePurpose;
	}
	public void setRolePurpose(String rolePurpose) {
		this.rolePurpose = rolePurpose;
	}
	@Override
	public String toString() {
		return "RoleModel [roleName=" + this.roleName + ", rolePurpose=" + this.rolePurpose+"]";
	}
	
}
