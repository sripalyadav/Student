package com.sripal.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sripal.Entity.SsnidEntity;
import com.sripal.repository.SsnidRepository;

public class CustomUserdetailsserviceimpl implements UserDetailsService {

	@Autowired
	private SsnidRepository ssnrepo;
	
	@Override
	public UserDetails loadUserByUsername(String name){
		
	SsnidEntity entity = ssnrepo.findByName(name).orElseThrow(() ->
    new UsernameNotFoundException("User not found with username or email:" + name));
	
	return new CostumeUserDetails(entity);
	
	}

}
