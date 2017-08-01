package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class BlogNotFoundException extends BlogitAwayException{
	
	public BlogNotFoundException() {
		super();
	}

	public BlogNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BlogNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogNotFoundException(String message) {
		super(message);
	}

	public BlogNotFoundException(Throwable cause) {
		super(cause);
	}
}