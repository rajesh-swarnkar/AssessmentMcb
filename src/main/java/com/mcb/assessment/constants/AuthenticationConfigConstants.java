package com.mcb.assessment.constants;


	public class AuthenticationConfigConstants {
	    public static final String SECRET_KEY = "secret";
	    public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hrs 
	    public static final String TOKEN_PREFIX = "Bearer ";
	    public static final String HEADER_STRING = "Authorization";
	    public static final String SIGN_UP_URL = "/authenticate";
	}

