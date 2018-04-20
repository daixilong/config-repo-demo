package com.xdl.config_client.exception;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Controller
public class CustomErrorController extends AbstractErrorController {
	Log log=LogFactory.getLog(CustomErrorController.class);
	
	public CustomErrorController() {
		super(new DefaultErrorAttributes());
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/error")
	public String getErrorPath() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		// TODO Auto-generated method stub
		Map<String, Object> model = getErrorAttributes(request, true);
		Throwable cause=getCause(request);
		int status =  (Integer)model.get("status");
		//错误信息
		String message = (String)model.get("message");
		//友好提示
		String errorMessage = getErrorMessage(cause);
		String requestPath = (String)model.get("path");
		List<FieldError> filedErrors = getFieldError(model,cause);
		System.out.println("状态:"+status);
		System.out.println("message:"+message);
		System.out.println("errorMessage:"+errorMessage);
		System.out.println("请求的方法:"+requestPath);
		System.out.println("请求的方法:"+filedErrors.size());
		log.info("------");
		return null;
	}
	
	protected Throwable getCause(HttpServletRequest request) {
		Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
		if (error != null) {
			while (error instanceof ServletException && error.getCause() != null) {
				error = ((ServletException) error).getCause();
			}
		}
		return error;
	}
	
	protected String getErrorMessage(Throwable ex) {
		if(ex instanceof ParentException){
			return ex.getMessage();
		}else{
			return "服务器错误,请联系管理员";
		}
		
	}

	
	protected List<FieldError> getFieldError(Map<String, Object> model,Throwable cause){
		List<FieldError> filedErrors = (List<FieldError>)model.get("errors");
		if(filedErrors!=null){
			return filedErrors;
		}
		if(cause instanceof FormFieldException){
			FormFieldException  fe = (FormFieldException)cause;
			return fe.getErrors();
		}
		return null;
		
		
	}
}
