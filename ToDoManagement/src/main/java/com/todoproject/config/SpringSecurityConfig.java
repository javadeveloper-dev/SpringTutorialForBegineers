package com.todoproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((authorize)->{
//			authorize.requestMatchers(HttpMethod.POST,"/todo/**").hasRole("ADMIN");
//			authorize.requestMatchers(HttpMethod.PUT,"/todo/**").hasRole("ADMIN");
//			authorize.requestMatchers(HttpMethod.DELETE,"/todo/**").hasRole("ADMIN");
//			authorize.requestMatchers(HttpMethod.GET,"/todo/**").hasAnyRole("ADMIN","USER");
//			authorize.requestMatchers(HttpMethod.GET,"/todo/**").permitAll();
			authorize.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails pankaj=User.builder().username("pankaj").password(passwordEncoder().encode("password")).roles("USER").build();
//		UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(pankaj,admin);
//	}
	
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
		
	}
}
