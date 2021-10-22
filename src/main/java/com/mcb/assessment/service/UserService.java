package com.mcb.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mcb.assessment.entity.LoginUser;
import com.mcb.assessment.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  BCryptPasswordEncoder passwordEncoder;
    public LoginUser readUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseGet(LoginUser::new);
    }
    
    public LoginUser updateAttempt(String username) {
    	LoginUser user=userRepository.findByUsername(username).orElseGet(LoginUser::new);
    	user.setAttempt(user.getAttempt()+1);
    	return userRepository.save(user);
    }

	public LoginUser updateAttemptZero(String username) {
		LoginUser user=userRepository.findByUsername(username).orElseGet(LoginUser::new);
    	user.setAttempt(0L);
    	System.out.println("save successful!");
    	return userRepository.save(user);
	}
    
	/*
	 * public void createUser(UserCreateRequest userCreateRequest) { LoginUser
	 * apiUser = new LoginUser(); Optional<LoginUser> byUsername =
	 * userRepository.findByUsername(userCreateRequest.getUsername()); if
	 * (byUsername.isPresent()) { throw new
	 * RuntimeException("User already registered. Please use different username.");
	 * } apiUser.setUsername(userCreateRequest.getUsername());
	 * apiUser.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
	 * apiUser.setRole(userCreateRequest.getRole()); userRepository.save(apiUser); }
	 */
}