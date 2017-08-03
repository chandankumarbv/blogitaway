package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class NoCommentsFoundException extends BlogitAwayException{
	
	public NoCommentsFoundException() {
		super();
	}

	public NoCommentsFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoCommentsFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoCommentsFoundException(String message) {
		super(message);
	}

	public NoCommentsFoundException(Throwable cause) {
		super(cause);
	}
}
