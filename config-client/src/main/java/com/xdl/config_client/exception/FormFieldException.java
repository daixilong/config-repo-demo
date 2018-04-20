package com.xdl.config_client.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.FieldError;

public class FormFieldException extends ParentException {
	
	private Log log=LogFactory.getLog(FormFieldException.class);
	
	List<FieldError> errors = new ArrayList<FieldError>();
    public FormFieldException() {
        super();
    }


    public FormFieldException(String objectName,String field,String error) {
    	
        super("field "+field+" "+error);
        System.out.println("objectName:"+objectName);
        System.out.println("field:"+field);
        System.out.println("error:"+error);
        FieldError fields = new FieldError(objectName,field,error);
        log.info(objectName+"["+field+"]"+error);
        errors.add(fields);
        
    }


	public List<FieldError> getErrors() {
		return errors;
	}


	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}
}
