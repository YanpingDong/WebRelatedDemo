package com.dyp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "regist", description = "regist", basePath="/regist") // Swagger annotation
@Controller
@RequestMapping("/regist")
public class TestApiController {
	/**
     * 注册用户
     * @param user
     */
	@ApiOperation(value = "xxxxx", httpMethod = "GET xxx", notes = "add user ")
    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<?> regist(String name) {
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
    
    @ResponseBody
    @RequestMapping(value = { "/test" }, method = RequestMethod.GET)
    public ResponseEntity<?> test() {
        return new ResponseEntity<String>("test", HttpStatus.OK);
    }
}
