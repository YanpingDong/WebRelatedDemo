package com.dyp.test.mockito;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoBasicUseWay {
    /*
     * mock对象就是在调试期间用来作为真实对象的替代品。
     * mock测试就是在测试过程中，对那些不容易构建的对象用一个虚拟对象来代替测试的方法就叫mock测试。
     */
	@SuppressWarnings("unchecked")
	@Test  
    public void simpleTest(){  
          
        //创建mock对象，参数可以是类，也可以是接口  
        List<String> list = mock(List.class);  
          
        //设置方法的预期返回值  
        when(list.get(0)).thenReturn("helloworld");  
      
        String result = list.get(0);  
          
        //验证方法调用(是否调用了get(0))  
        verify(list).get(0);  
          
        assertEquals("helloworld", result);  
    }  
	/*
	 * Matchers类内加你有很多参数匹配器  anyInt、anyString、anyMap.....Mockito类继承于Matchers,
	 * Stubbing时使用内建参数匹配器
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void argumentMatcherTest(){
		
		List<String> list = mock(List.class);
		
		when(list.get(anyInt())).thenReturn("hello","world");
		
		String result = list.get(0)+list.get(1);
		
		System.out.println(result);
		
		verify(list,times(2)).get(anyInt());
		
		assertEquals("helloworld", result);
		
	}
	
    /*
     *  需要注意的是：如果使用参数匹配器，那么所有的参数都要使用参数匹配器，不管是stubbing还是verify的时候都一样。
     */
	@SuppressWarnings("unchecked")
	@Test
	public void argumentMatcherTest2(){
		
		Map<Integer,String> map = mock(Map.class);
		when(map.put(anyInt(),anyString())).thenReturn("hello");//anyString()替换成"hello"就会报错
		map.put(1, "world");
		verify(map).put(eq(1), eq("world")); //eq("world")替换成"world"也会报错
		
	}

	/*
	 * 方法调用的验证(具体的调用次数、至少一次，一次也没有)
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void verifyInvocate(){
		
		List<String> mockedList = mock(List.class);
		//using mock 
		 mockedList.add("once");
		 mockedList.add("twice");
		 mockedList.add("twice");
		 
		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");
		 
		 /**
		  * 基本的验证方法
		  * verify方法验证mock对象是否有没有调用mockedList.add("once")方法
		  * 不关心其是否有返回值，如果没有调用测试失败。
		  */
		 verify(mockedList).add("once"); 
		 verify(mockedList, times(1)).add("once");//默认调用一次,times(1)可以省略
		 
		 
		 verify(mockedList, times(2)).add("twice");
		 verify(mockedList, times(3)).add("three times");
		 
		 //never()等同于time(0),一次也没有调用
		 verify(mockedList, times(0)).add("never happened");
		 
		 //atLeastOnece/atLeast()/atMost()
		 verify(mockedList, atLeastOnce()).add("three times");
		 verify(mockedList, atLeast(2)).add("twice");
		 verify(mockedList, atMost(5)).add("three times");

	}
}
