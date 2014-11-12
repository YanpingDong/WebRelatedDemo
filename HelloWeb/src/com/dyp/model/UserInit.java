package com.dyp.model;

import java.util.ArrayList;
import java.util.List;

public class UserInit {
    public static List<User> initUser()
    {
    	List<User> users = new ArrayList<User>();
    	users.add(new User("test01","1"));
    	users.add(new User("test02","2"));
    	
    	return users;
    }
	public UserInit() {
		// TODO Auto-generated constructor stub
	}

}
