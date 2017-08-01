package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class InvalidCommentException extends BlogitAwayException{
	
	public InvalidCommentException() {
		super();
	}

	public InvalidCommentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidCommentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCommentException(String message) {
		super(message);
	}

	public InvalidCommentException(Throwable cause) {
		super(cause);
	}
}