package com.mcb.assessment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mcb.assessment.service.AuthenticationUserDetailService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
    private  AuthenticationUserDetailService authenticationUserDetailService;
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("SecurityConfiguration: >configure(AuthenticationManagerBuilder auth) called:");
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure(HttpSecurity http)-> "+http);
		http.headers().frameOptions().sameOrigin();
		
		http.csrf().disable()
			.cors().and()
			.authorizeRequests().antMatchers("/authenticate").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/v2/api-docs", "/configuration/ui","/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/marks/**","/group/**","/student/**","/subject/**","/subjectTeacher/**").permitAll()
			.antMatchers("/totalMarks","/studentcount","/liststudentmarks").hasRole("admin")
			.anyRequest().authenticated()
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }



	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}