package com.dyp.test.spring.test;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DatasourceNamespaceHandlerSupport extends NamespaceHandlerSupport {

	@Override
	public void init() {
		// register name have to set to the name of aty xsd root element name == "<xsd:element name="datasource">"
		registerBeanDefinitionParser("datasource",
		        new DatasourceBeanDefinitionParser());
	}

}
