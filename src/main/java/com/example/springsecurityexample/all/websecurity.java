package com.example.springsecurityexample.all;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class websecurity {
	
//	@Bean
//	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//	    manager.createUser(User.withUsername("user")
//	      .password(bCryptPasswordEncoder.encode("userPass"))
//	      .roles("USER")
//	      .build());
//	    manager.createUser(User.withUsername("admin")
//	      .password(bCryptPasswordEncoder.encode("adminPass"))
//	      .roles("USER", "ADMIN")
//	      .build());
//	    return manager;
//	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(bCryptPasswordEncoder)
	      .and()
	      .build();
	}

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests().requestMatchers("/","/login","/h2-console","/h2-console/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin(frl -> {
					frl.loginPage("/login");
					frl.loginProcessingUrl("/login");
					frl.defaultSuccessUrl("/");
					frl.failureUrl("/login?failed");
				})
				/* .and() */.csrf().disable().build();
	}
}
