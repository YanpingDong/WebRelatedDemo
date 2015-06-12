package com.dyp.java.based.mvc.service;

import org.springframework.stereotype.Service;

import com.dyp.java.based.mvc.persist.entity.User;
import com.dyp.java.based.mvc.service.dto.UserDto;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserDto, Long> implements UserService {


}
