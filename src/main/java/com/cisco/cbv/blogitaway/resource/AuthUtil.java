package com.cisco.cbv.blogitaway.resource;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class AuthUtil {

	private static final String ISSUER = "blogitaway";
	private static final String SECRET = "blogitaway-secret";

	public static String issueToken() {
		Algorithm algorithmHS;
		try {
			algorithmHS = Algorithm.HMAC256(SECRET);
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		String token = JWT.create().withIssuer(ISSUER).withIssuedAt(Calendar.getInstance().getTime()).sign(algorithmHS);
		return token;
	}

	public static boolean verifyToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).acceptIssuedAt(30).build();
			verifier.verify(token);
		} catch (IllegalArgumentException | UnsupportedEncodingException | JWTVerificationException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
