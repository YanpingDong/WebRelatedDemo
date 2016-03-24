package org.bootapp.exception.handle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.bootapp.model.Error;

//@ControllerAdvice("org.bootapp.controller")
public class ControllerExcptionAdvice {
	@ExceptionHandler(MyException.class)  
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  
	@ResponseBody
    public Error handleUnexpectedServerError(MyException ex,HttpServletRequest request) {  
    	Error error = new Error();
    	error.setErrorCode(HttpStatus.BAD_REQUEST.value());
    	error.setErrorMessage(ex.getMessage());
    	error.setUri(request.getServletPath());
    	error.setMethod(request.getMethod());
        return error;  
    }
	
	@ExceptionHandler(MissingServletRequestParameterException.class)  
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
    public Error handleUnexpectedServerError(MissingServletRequestParameterException ex,HttpServletRequest request) {  
    	Error error = new Error();
    	error.setErrorCode(HttpStatus.BAD_REQUEST.value());
    	error.setErrorMessage(ex.getMessage());
    	error.setUri(request.getServletPath());
    	error.setMethod(request.getMethod());
        return error;  
    }
}
