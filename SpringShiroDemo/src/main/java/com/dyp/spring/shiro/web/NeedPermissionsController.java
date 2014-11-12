package com.dyp.spring.shiro.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyp.spring.shiro.service.NeedPermissionService;

@Controller  
@RequestMapping("permit")  
public class NeedPermissionsController {
	private static final transient Logger log = 
			LoggerFactory.getLogger(NeedPermissionsController.class);
	
	@Autowired
	@Qualifier(value="needPermissionService")
	NeedPermissionService nps;
	
	@RequiresAuthentication()
    @RequiresPermissions("admin:manage")
	@RequestMapping("/interface1")  
    public @ResponseBody String getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {  
		log.info("this is authorization control at controller level ");
		return new String("this interface need permission"); 
    }  
	
	@RequestMapping("/interface2")  
    public @ResponseBody String getInfoFromService(HttpServletRequest request, HttpServletResponse response) throws IOException {  
		log.info("this is authorization control at object function level ");
		return nps.needPermissionFuc(); 
    }  
}
