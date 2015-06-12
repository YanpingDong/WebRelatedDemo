package com.dyp.JpaProject.persist.service;

import org.springframework.stereotype.Service;

import com.dyp.JpaProject.persist.entity.User;
import com.dyp.JpaProject.persist.service.dto.UserDto;


@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserDto, Long> implements UserService {


}