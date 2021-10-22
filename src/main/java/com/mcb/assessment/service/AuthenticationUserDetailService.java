package com.mcb.assessment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mcb.assessment.entity.LoginUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {
	@Autowired 
    private  UserService userService;
	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUserName called!!");
        LoginUser user = userService.readUserByUsername(username);
        
        if (user == null) {
        	 System.out.println("LoginUser not found"+username);
            throw new UsernameNotFoundException(username);
        }
        System.out.println("LoginUser found: "+user.getUsername()+": "+user.getPassword()+": "+user.getRole());
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user.getRole()));

		/*
		 * return new
		 * org.springframework.security.core.userdetails.User(user.getUsername(),
		 * user.getPassword(),new ArrayList<>());
		 */
    }
    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}