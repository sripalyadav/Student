package com.sripal.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userdetails;
	
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http.authorizeRequests()
		.antMatchers("/Home").permitAll()
		.antMatchers("/save").authenticated()
		
		.antMatchers("/findAll").authenticated()
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/"))
		
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/");
	}
	 
	 
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 auth.userDetailsService(userdetails);
		
	}
	 
	 

}
