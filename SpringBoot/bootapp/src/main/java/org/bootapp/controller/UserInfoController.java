package org.bootapp.controller;
import org.bootapp.exception.handle.MyException;
import org.bootapp.model.Error;
import org.bootapp.model.User;
import org.bootapp.service.ForTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(basePath = "/user/", value = "user", description = "CRUD user info", produces = "application/json")
@RestController
@RequestMapping(value = "/user/")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private ForTestService forTestService;
    
    @RequestMapping(value="{userid}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Get user info by user id", notes = "Get user info by user id ------please use this to describe detail ", response=String.class)
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors",response=Error.class),
            @ApiResponse(code = 401, message = "Unauthorized",response=Error.class),
            @ApiResponse(code = 403, message = "Forbidden",response=Error.class),
            @ApiResponse(code = 404, message = "Not Found",response=Error.class)
            })
    public String getUserInfo(@ApiParam(value = "user id", required = true, defaultValue="123" )
                                 @PathVariable(value = "userid") int userid,
    		                     @ApiParam(value = "gender", required = true, defaultValue="male" ) 
                                 @RequestParam(value="gender",required=true) String gender) throws MyException {
    	
    	if(null == gender)
    	{
    		if(logger.isDebugEnabled())
    			logger.debug("start to judge gender");
    		throw new MyException("missed gender parameter, in request uri. please add ?gender=male or female");
    	}
    		
    	String userInfo = forTestService.getInfo(userid);
    		 	
    	return "user info : " + userid + " ; " + "user gender : " + gender + " ; " + "user info : " + userInfo;
    }
    
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")  
    @ApiOperation(value = "Create new user", notes = "Creates new user---please use this to describe detail")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors",response=Error.class),
            @ApiResponse(code = 401, message = "Unauthorized",response=Error.class),
            @ApiResponse(code = 403, message = "Forbidden",response=Error.class),
            @ApiResponse(code = 404, message = "Not Found",response=Error.class)
            })
    public User updateUserInfo(@ApiParam(value = "user json", required = true,defaultValue="{\"id\": 0,\"xxxName\": \"xxxx\"}" ) @RequestBody User user) {  
	
	    return user;  
	}  
    
    //write here or in org.bootapp.exception.handle.ControllerExcptionAdvice.java
    /*@ExceptionHandler(MissingServletRequestParameterException.class)  
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  
    public Error handleUnexpectedServerError(MissingServletRequestParameterException ex,HttpServletRequest request) {  
    	Error error = new Error();
    	error.setErrorCode(HttpStatus.BAD_REQUEST.value());
    	error.setErrorMessage(ex.getMessage());
    	error.setUri(request.getServletPath());
    	error.setMethod(request.getMethod());
        return error;  
    }*/ 
}
