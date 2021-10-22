package com.mcb.assessment.model;

public class AuthenticationResponse {
	
	private final String jwt;
	private final String role;
	private final Long attempt;

	public AuthenticationResponse(String jwt,String role,Long attempts) {
		super();
		this.jwt = jwt;
		this.role=role;
		this.attempt=attempts;
	}

	public String getJwt() {
		return jwt;
	}

	public String getRole() {
		return role;
	}

	public Long getAttempt() {
		return attempt;
	}
	
	
	
	

}
