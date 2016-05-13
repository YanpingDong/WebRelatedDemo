package org.bootapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.oauth1.signature.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.utilities.OAuthSignatureGenerator;

class myX509TrustManager implements X509TrustManager {
    
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) {
        System.out.println("cert: " + chain[0].toString() + ", authType: " + authType);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

/**
 * 重写一个方法
 * @author Administrator
 *
 */
class myHostnameVerifier implements HostnameVerifier {

    public boolean verify(String hostname, SSLSession session) {
        System.out.println("Warning: URL Host: " + hostname + " vs. " + session.getPeerHost());
        return true;
    }
}

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest("server.port:0")
public class AppTest 
{
	@Value("${for.test.value}")
    private String forTestValue;
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${spring.profiles.active}")
	private String springActive;
	
	@Value("${logging.config}")
	private String loggingConfig;
	
	@Test
	public void testHttpsResttemplate() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException
	{
		
		OAuthSignatureGenerator osg = new OAuthSignatureGenerator();
		/*String signature = osg.generateSignature("GET", 
				"https://developers.rovicorp.com/api/v1/resolve/2/data_movie?id=914806985&in=en-US&in2=en-*&in3=*", 
"6128e4ec8e45ec08a34e0a8ffefca499e751f874ecde95d9a4fa3aa0e1fe865b", 
"3df549cdf08d8822ba58d3371e9c09540a875a6dff163c67121469ddcfaf30da");*/
		/*String signature = osg.generateSignature("GET", 
				"https://developers.rovicorp.com/api/v1/resolve/2/data_series?id=915363654&in=en-US&in2=en-*&in3=*", 
"6128e4ec8e45ec08a34e0a8ffefca499e751f874ecde95d9a4fa3aa0e1fe865b", 
"3df549cdf08d8822ba58d3371e9c09540a875a6dff163c67121469ddcfaf30da");*/
		String signature = osg.generateSignature("GET", 
				"https://developers.rovicorp.com/api/v1/resolve/2/data_episode?id=906208182&in=en-US&in2=en-*&in3=*", 
"6128e4ec8e45ec08a34e0a8ffefca499e751f874ecde95d9a4fa3aa0e1fe865b", 
"3df549cdf08d8822ba58d3371e9c09540a875a6dff163c67121469ddcfaf30da");
		
		System.out.println(osg.buildAuthorizationHeader("6128e4ec8e45ec08a34e0a8ffefca499e751f874ecde95d9a4fa3aa0e1fe865b", signature));

		RestTemplate restTemplate = new RestTemplate(getRequestFactory());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", osg.buildAuthorizationHeader("6128e4ec8e45ec08a34e0a8ffefca499e751f874ecde95d9a4fa3aa0e1fe865b", signature));
		RequestEntity<String> requestEntity = new RequestEntity<String>(headers, HttpMethod.GET, URI.create("https://developers.rovicorp.com/api/v1/resolve/2/data_episode?id=906208182&in=en-US&in2=en-*&in3=*"));
		System.out.println(restTemplate.exchange(requestEntity, String.class).getBody());
		
	}
	
	private HttpComponentsClientHttpRequestFactory getRequestFactory () {
		// Work only for httpClient 4.4+
		SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null,
					new TrustStrategy() {
						@Override
						public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				            return true;
						}
					}
				).build();
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}
				
		CloseableHttpClient httpClient
			= HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
							 	  .setSSLContext(sslContext)
						 .build();
		
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		
		return requestFactory;
	}
	

}



