package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class InvalidBlogException extends BlogitAwayException{
	
	public InvalidBlogException() {
		super();
	}

	public InvalidBlogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidBlogException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBlogException(String message) {
		super(message);
	}

	public InvalidBlogException(Throwable cause) {
		super(cause);
	}
}
