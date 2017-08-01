package com.cisco.cbv.blogitaway.model;

@SuppressWarnings("serial")
public class NoBlogsFoundException extends BlogitAwayException {

	public NoBlogsFoundException() {
		super();
	}

	public NoBlogsFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoBlogsFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoBlogsFoundException(String message) {
		super(message);
	}

	public NoBlogsFoundException(Throwable cause) {
		super(cause);
	}
}
