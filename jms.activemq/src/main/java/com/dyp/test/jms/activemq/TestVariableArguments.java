package com.dyp.test.jms.activemq;

public class TestVariableArguments {
	public String[] args;
	public TestVariableArguments( String... arguments)
	{
			args = arguments;
	}
	
	public void myPrint()
	{
		int length = args.length;
		for(int i = 0; i < length; i++)
			System.out.println(args[i]);
	}
}
