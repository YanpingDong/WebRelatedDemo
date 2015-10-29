package com.dyp.test.spring.test;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class DatasourceBeanDefinitionParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext context) {
		RootBeanDefinition def = new RootBeanDefinition();

	    // 设置Bean Class
	    def.setBeanClass(DataSourceInfo.class);

	    // 注册ID属性
	    String id = element.getAttribute("id");
	    BeanDefinitionHolder idHolder = new BeanDefinitionHolder(def, id);
	    BeanDefinitionReaderUtils.registerBeanDefinition(idHolder,
	        context.getRegistry());

	    // 注册属性
	    String url = element.getAttribute("url");
	    String userName = element.getAttribute("userName");
	    String password = element.getAttribute("password");

	    BeanDefinitionHolder urlHolder = new BeanDefinitionHolder(def, url);
	    BeanDefinitionHolder userNameHolder = new BeanDefinitionHolder(def,
	        userName);
	    BeanDefinitionHolder passwordHolder = new BeanDefinitionHolder(def,
	        password);

	    BeanDefinitionReaderUtils.registerBeanDefinition(urlHolder,
	        context.getRegistry());
	    BeanDefinitionReaderUtils.registerBeanDefinition(userNameHolder,
	        context.getRegistry());
	    BeanDefinitionReaderUtils.registerBeanDefinition(passwordHolder,
	        context.getRegistry());

	    def.getPropertyValues().addPropertyValue("url", url);
	    def.getPropertyValues().addPropertyValue("userName", userName);
	    def.getPropertyValues().addPropertyValue("password", password);

	    return def;
	}

}
