package com.dyp.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTutorial {
	private static final transient Logger log = LoggerFactory.getLogger(ShiroTutorial.class);
	
	public static void main(String[] args)
	{
		log.info("My First Apache Shiro Application");
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject currentUser = SecurityUtils.getSubject();
		//if not load, regist a user
		if ( !currentUser.isAuthenticated() ) {

			   //collect user principals and credentials in a gui specific manner
			   //such as username/password html form, X509 certificate, OpenID, etc.
			   //We'll use the username/password example here since it is the most common.
			   UsernamePasswordToken token = new UsernamePasswordToken("guest", "guest");

			   //this is all you have to do to support 'remember me' (no config - built in!):
			   token.setRememberMe(true);

			   try {

				   currentUser.login( token );
  
				   //if no exception, that's it, we're done!

				} catch ( UnknownAccountException uae ) {
                   log.info("username wasn't in the system, show them an error message?");
				   //username wasn't in the system, show them an error message?

				} catch ( IncorrectCredentialsException ice ) {
				   log.info("password didn't match, try again?");
				   //password didn't match, try again?

				} catch ( LockedAccountException lae ) {
				   log.info("account for that username is locked - can't login.  Show them a message?");
				   //account for that username is locked - can't login.  Show them a message?

				} catch ( AuthenticationException ae ) {
				   log.info("unexpected condition - error?");
				   //unexpected condition - error?

				}

			}
	
		//print their identifying principal (in this case, a username):
		log.info( "User [" + currentUser.getPrincipal() + "] logged in successfully." );
		
        // test whether have specified permit
		//if ( currentUser.isPermitted( "perm" ) )
		if ( currentUser.isPermitted( "perm1:special" ) ) {

		   log.info("You may ues this  ring.  Use it wisely.");

		} else {

		   log.info("Sorry, this rings are for other masters only.");

		}	
		//removes all identifying information and invalidates their session too.
		currentUser.logout(); 
		//if ( currentUser.isPermitted( "perm" ) )
		if ( currentUser.isPermitted( "perm1:special" ) ) {
		   log.info("You may ues this  ring.  Use it wisely.");

		} else {
		   log.info("Sorry, this rings are for other masters only.");
		}
	}
}
