package org.test.config.controller;

import org.bootapp.dao.ForTestDaoImp;
import org.bootapp.dao.ForTestDaoImpStub;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
/**
 * just filter the object that you have mocked, such as ForTestDaoImp is mocked by ForTestDaoImpStub
 */
@ComponentScan(basePackages={"org.bootapp.*"}, useDefaultFilters=true,
               excludeFilters={@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value = {ForTestDaoImpStub.class, ForTestDaoImp.class}) } )
public class UserInfoControllerConfig {
}
