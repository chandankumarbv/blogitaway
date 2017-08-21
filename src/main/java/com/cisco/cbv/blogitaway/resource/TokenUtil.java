package com.cisco.cbv.blogitaway.resource;

import com.cisco.cbv.blogitaway.dao.TokenDaoImpl;
import com.cisco.cbv.blogitaway.model.JWTToken;

public class TokenUtil {

	public static String issueAndStoreToken(String userName) {
		String token = AuthUtil.issueToken(userName);
//		JWTToken jwtToken = TokenDaoImpl.getInstance().read(userName);
//		if (jwtToken != null) {
//			jwtToken.setToken(token);
//			TokenDaoImpl.getInstance().update(jwtToken);
//		} else {
//			TokenDaoImpl.getInstance().store(userName, token);
//		}
		return token;
	}
}
