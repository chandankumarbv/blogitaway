package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class InvalidValueException extends BlogitAwayException{
	
	public InvalidValueException() {
		super();
	}

	public InvalidValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(Throwable cause) {
		super(cause);
	}
}
