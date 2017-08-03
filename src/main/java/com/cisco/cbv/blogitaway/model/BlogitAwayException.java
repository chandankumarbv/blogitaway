package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class BlogitAwayException extends RuntimeException{

	public BlogitAwayException() {
		super();
	}

	public BlogitAwayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BlogitAwayException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogitAwayException(String message) {
		super(message);
	}

	public BlogitAwayException(Throwable cause) {
		super(cause);
	}
	
}
