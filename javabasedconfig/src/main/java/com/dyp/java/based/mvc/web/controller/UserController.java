package com.dyp.java.based.mvc.web.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dyp.java.based.mvc.service.UserService;
import com.dyp.java.based.mvc.service.dto.UserDto;


@Controller
@Scope("request")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource ms;
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        logger.debug("redirect to home page");
        return new ModelAndView("home");
    }

   
    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public @ResponseBody List<UserDto> usersList() {
        logger.debug("get json user list");
        return userService.findAll();
    }
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
    	logger.debug("display user list");
        ModelAndView mv= new ModelAndView("usersView");
        mv.addObject("usersModel", userService.findAll());

        return mv;
    }
    
    @RequestMapping(value = "list")
	public String list(Model model)
    {
    	model.addAttribute("myValue", "xxxxxxxxxxxxxxxx");
		return "test";
    }
    
}    
