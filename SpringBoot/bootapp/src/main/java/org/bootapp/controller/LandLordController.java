package org.bootapp.controller;
import org.bootapp.exception.handle.MyException;
import org.bootapp.model.Error;
import org.bootapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Api(basePath = "/user/", value = "Landlords", description = "Operations with Landlords", produces = "application/json")
@RestController
@RequestMapping(value = "/user/")
public class LandLordController {

    private static final Logger logger = LoggerFactory.getLogger(LandLordController.class);

    
    
    @RequestMapping(value="{userid}", method = RequestMethod.GET)
    @ApiOperation(value = "Create new Landlord", notes = "Creates new Landlord", response=String.class)
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors",response=Error.class),
            @ApiResponse(code = 401, message = "Unauthorized",response=Error.class),
            @ApiResponse(code = 403, message = "Forbidden",response=Error.class),
            @ApiResponse(code = 404, message = "Not Found",response=Error.class)
            })
    public String createLandLord(@ApiParam(value = "user id", required = true, defaultValue="123" )
                                 @PathVariable(value = "userid") String userid,
    		                     @ApiParam(value = "p", required = true, defaultValue="p" ) 
                                 @RequestParam(value="p",required=true) String xxx, 
                                 @ApiParam(value = "b", required = false, defaultValue="b" ) 
    		                     @RequestParam(value="b",required=false) String b) throws MyException {
    	return "test" + userid + " : " ;
    }

    public String convertStringToDate(@RequestParam(value="date",required=false) String date )
    {
    	return "date string is ";
    }
    
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")  
    @ApiOperation(value = "Create new user", notes = "Creates new user---notes detail")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors",response=Error.class),
            @ApiResponse(code = 401, message = "Unauthorized",response=Error.class),
            @ApiResponse(code = 403, message = "Forbidden",response=Error.class),
            @ApiResponse(code = 404, message = "Not Found",response=Error.class)
            })
    public User view(@ApiParam(value = "user json", required = true,defaultValue="{\"id\": 0,\"xxxName\": \"xxxx\"}" ) @RequestBody User user) {  
	
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
