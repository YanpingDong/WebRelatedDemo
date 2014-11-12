package com.dyp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {
	private String encodingParam;
	
	public CharacterFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		System.out.println("in destroy");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("my filter");
		arg0.setCharacterEncoding(encodingParam);
		arg2.doFilter(arg0, arg1);
		
		System.out.println("my filter end");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("in init");
		encodingParam = arg0.getInitParameter("encoding");
        if(encodingParam == null || "".equals(encodingParam.trim()))
        {
        	encodingParam = "UTF-8";
        }
	}

}
