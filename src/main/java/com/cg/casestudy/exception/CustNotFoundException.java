package com.cg.casestudy.exception;

public class CustNotFoundException extends Exception{

	public CustNotFoundException() {
		super();
	}

	public CustNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustNotFoundException(String message) {
		super(message);
	}

	public CustNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
