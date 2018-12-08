package com.palash.investment.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl extends UserModel implements UserDetails{

	private static final long serialVersionUID = -4472042481340530840L;

	public UserDetailsImpl(UserModel userInfo) {
		super(userInfo);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+super.getRoleModel().getRoleName()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		if(super.getCurrentStatus().equalsIgnoreCase("active")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(super.getCurrentStatus().equalsIgnoreCase("active")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if(super.getCurrentStatus().equalsIgnoreCase("active")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEnabled() {
		if(super.getCurrentStatus().equalsIgnoreCase("active")) {
			return true;
		}
		return false;
	}

}
