package com.palash.investment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pk_app_users")
public class UserModel extends MasterModel implements Serializable{

	private static final long serialVersionUID = -7000257466050146121L;
	@Column(name = "username",nullable = false,unique = true)
	private String username;
	@Column(name = "name",nullable = false)
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phone", nullable = false,unique = true)
	private String phone;
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address;
	@Column(name = "role_id",nullable = false,columnDefinition = "default 2")//2 for user//
	private int roleId;
	@Column(name = "user_type",columnDefinition=" default 'user' ")
	private String userType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private RoleModel roleModel;
	
	public UserModel() {
		
	}
	public UserModel(UserModel userInfo) {
		super.setId(userInfo.getId());
		super.setCreatedBy(userInfo.getCreatedBy());
		super.setCreationDate(userInfo.getCreationDate());
		super.setCurrentStatus(userInfo.getCurrentStatus());
		username = userInfo.username;
		name = userInfo.getName();
		email = userInfo.getEmail();
		phone = userInfo.getPhone();
		password = userInfo.getPassword();
		address = userInfo.getAddress();
		roleId = userInfo.getRoleId();
		roleModel = userInfo.getRoleModel();
		userType = userInfo.getUserType();
	}

	public UserModel(String username, String name, String email, String phone, String password, String address,
			int roleId, String userType, RoleModel role) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.roleId = roleId;
		this.userType = userType;
		this.roleModel = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	@Override
	public String toString() {
		return "UserModel [username=" + username + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", address=" + address + ", roleId=" + roleId + ", userType=" + userType
				+ ", role=" + roleModel + "]";
	}

	
	
	
}
