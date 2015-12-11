package com.test.client;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@Component
public class HttpReqClinet {
	
    private static RestTemplate restTemplate = null;
    private static String user_name = "zijufeng@tcl.com";
	private static String pass_word = "onetouch";
	private static String userpass = user_name + ":" + pass_word;

    @Autowired
    public HttpReqClinet(RestTemplate restTemplate)
    {
    	HttpReqClinet.restTemplate = restTemplate;
    }
    
	public static RestTemplate getRestTemplate() {
		return restTemplate;
	}
	public static <T> T postReqProxy(HostEnum host, MultiValueMap<String, Object> body, Class<T> responseType)throws RestClientException
	{
		byte[] encoded = createEncodedBaseOnBase64();
		
		String encodedString = new String(encoded);		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		headers.add("Content-Type",MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		headers.add("Authorization", "Basic " + encodedString);
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(body, headers);
		
		T returnObject = null;
		try{
			ResponseEntity<T> result = getRestTemplate().exchange(host.getRoute(), HttpMethod.POST, requestEntity, responseType);
			returnObject = result.getBody();
		}
		catch(HttpStatusCodeException e)
		{
			throw e;
		}
		catch(UnknownHttpStatusCodeException e)
		{
			wrapupToHttpStatusCodeExp(e);
		}
		catch(ResourceAccessException e)
		{
			wrapupToHttpStatusCodeExp(e);
		}
		catch(RestClientException e)
		{
			wrapupToHttpStatusCodeExp(e);
		}
		return returnObject;
	}

	private static byte[] createEncodedBaseOnBase64() {
		byte[] encoded = null;
		try {
			encoded = Base64.encodeBase64(userpass.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return encoded;
	}
	public static <T> T getReqProxy(HostEnum host,String parameter, Class<T> responseType)throws RestClientException
	{
		T returnObject = null;
		String url = host.getRoute()+ "?" + parameter;
		
		try
		{
			returnObject = getRestTemplate().getForObject(url, responseType);
		}
		catch(HttpStatusCodeException e)
		{
			throw e;
		}
		catch(UnknownHttpStatusCodeException e)
		{
			wrapupToHttpStatusCodeExp(e);
		}
		catch(ResourceAccessException e)
		{
			wrapupToHttpStatusCodeExp(e);
		}
		catch(RestClientException e)
		{
			wrapupToHttpStatusCodeExp(e);
		}
		
		return returnObject;
	}

	private static void wrapupToHttpStatusCodeExp(RestClientException e) {
		throw new HttpStatusCodeException(HttpStatus.SEE_OTHER, e.getMessage()) {
			private static final long serialVersionUID = 1L;};
	}
}
