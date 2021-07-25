/**
 * 
 */
package com.grich.hsnp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author william
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	protected AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	protected AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().disable();
		
		http.formLogin().successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
				.authorizeRequests()
				.antMatchers("/oauth/authorize", "/oauth/token", "/doc.html/**",
						 "/swagger-resources/**", "/webjars/**",
						"/v2/**", "/swagger-ui.html/**", "/img/**")
				.permitAll().anyRequest().authenticated().and().csrf().disable();
	}

}
