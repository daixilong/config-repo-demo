package com.xdl.config_client.exception;

public class ParentException extends RuntimeException {
	public ParentException(){
		super();
	}
	public ParentException(String message){
		super(message);
	}
	
	public ParentException(String message,Throwable e){
		super(message, e);
	}
}
