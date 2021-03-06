package com.dyp.spring.shiro.web;

import javax.servlet.http.HttpServletRequest;  

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
@RequestMapping("mydemo")  
public class UserController {  
    @RequestMapping(value="/getUserInfo")  
    public String getUserInfo(HttpServletRequest request){  
    	//currentUser是在MyRealm做验证的时候写到Session中的
        String currentUser = (String)request.getSession().getAttribute("currentUser");  
        System.out.println("当前登录的用户为[" + currentUser + "]");  
        request.setAttribute("currUser", currentUser);  
        return "user/info";  
    }  
}  