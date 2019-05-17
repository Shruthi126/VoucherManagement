package com.ecommerce.voucher.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    private AuthenticationEntryPoint authEntryPoint;
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic().realmName("Voucher")
         .authenticationEntryPoint(authEntryPoint)
         .and()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 //sessionManagement STATELESS policy will authenticate user everytime  if not once correct creds is given it will give results even if worng creds 
		 //are given later
    }

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    
    	auth.inMemoryAuthentication().withUser("Admin").password("{noop}nobody").roles("USER");
    	
 
    }
}
