
package com.mcb.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.assessment.entity.LoginUser;
import com.mcb.assessment.model.AuthenticationRequest;
import com.mcb.assessment.model.AuthenticationResponse;
import com.mcb.assessment.service.AuthenticationUserDetailService;
import com.mcb.assessment.service.UserService;
import com.mcb.assessment.util.JwtUtil;

import lombok.RequiredArgsConstructor;

//@RestControllerAdvice
@RestController
@RequestMapping(value = "")
@RequiredArgsConstructor
public class UserController {

	/*
	 * @Autowired private UserService userService;
	 */
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthenticationUserDetailService authenticationUserDetailService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
					);
		}catch(BadCredentialsException e) {

			LoginUser user= userService.updateAttempt(request.getUsername());
			if(user!=null && user.getAttempt()>=3)
				return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse("User Blocked",null,user.getAttempt()),
						HttpStatus.OK);
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(e.getMessage(),null,user.getAttempt()),HttpStatus.OK);
		}
		
		final UserDetails userDetails=authenticationUserDetailService.loadUserByUsername(request.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		LoginUser user= userService.readUserByUsername(request.getUsername());
		if(user!=null && user.getAttempt()>=3)
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse("User Blocked",null,user.getAttempt()),
					HttpStatus.OK);

		user= userService.updateAttemptZero(request.getUsername());
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt,user.getRole(),null),
				HttpStatus.OK);
	}

	/*
	 * @PostMapping public ResponseEntity createUser(@RequestBody
	 * AuthenticationRequest userCreateRequest) {
	 * userService.createUser(userCreateRequest); return
	 * ResponseEntity.ok().build(); }
	 */

	
}
