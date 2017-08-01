package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class CommentNotFoundException extends BlogitAwayException{
	
	public CommentNotFoundException() {
		super();
	}

	public CommentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommentNotFoundException(String message) {
		super(message);
	}

	public CommentNotFoundException(Throwable cause) {
		super(cause);
	}
}