package com.sripal.Configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sripal.Entity.SsnidEntity;

public class CostumeUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2318109662259262685L;

	@Autowired
	private SsnidEntity Entity;
	
	
	
	public CostumeUserDetails(SsnidEntity entity) {
		super();
		Entity = entity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return Entity.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
