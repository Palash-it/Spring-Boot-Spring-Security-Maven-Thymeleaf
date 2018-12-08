package com.palash.investment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "pkn_app_permissions")
public class PermissionModel extends MasterModel implements Serializable{

	private static final long serialVersionUID = -7868365671648267909L;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "module_id")
	private int moduleId;
	@Column(name = "role_id")
	private int roleId;
	@Column(name = "permission_level")
	private int permissionLevel;
	
	
	public PermissionModel() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getModuleId() {
		return this.moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPermissionLevel() {
		return this.permissionLevel;
	}
	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}
	@Override
	public String toString() {
		return "PermissionModel [userId=" + this.userId + ", moduleId=" + this.moduleId + ", roleId=" + this.roleId
				+ ", permissionLevel=" + this.permissionLevel + "]";
	}
	
	
	
}
