package com.gbh.core;

public class BookStoreException extends RuntimeException {

	public BookStoreException(String message) {
		super(message);
	}

	public BookStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookStoreException(Throwable cause) {
		super(cause);
	}

	public BookStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
