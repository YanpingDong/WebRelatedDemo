import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import models.ErrorRoot;
import models.GooglePlace;
import models.GooglePlaceResult;
import models.Root;
import models.meters.MeterRoot;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.test.client.HostEnum;
import com.test.client.HttpReqClient;
import com.test.client.JsonUtils;


/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-context.xml"})*/
public class RESTClientTest {
	
	@Autowired
    private RestTemplate restTemplate;
    
	
	@Test
	public void test() {
		//String message = restTemplate.getForObject("http://api.parkme.com/Lots?pub_id=3f1dc7ee&chk=ec5fd76b8b8bdcfa0e2538ca8eb908c5&det=1&bbox=-121.87847319160458|37.329422118761734|-120.87847319160458|38.329422118761734&max=20&duration=2&entry_time=2015-11-25T8:20", String.class);
		//LotInfo lotinfo = restTemplate.getForObject("http://api.parkme.com/Lots?pub_id=3f1dc7ee&chk=264e2dd5847bd29d1819aa4993ffae21&det=1&bbox=-122.919|37.27489|-121.919|38.27489&max=20", LotInfo.class);
		//Phone lotinfo = restTemplate.getForObject("http://10.120.137.41:8080/thridPartAPIServer/Lots", Phone.class);
		
		//System.out.println(message);
		
		Root lotinfo = restTemplate.getForObject("http://api.parkme.com/Lots?pub_id=3f1dc7ee&chk=264e2dd5847bd29d1819aa4993ffae21&det=1&bbox=-122.919|37.27489|-121.919|38.27489&max=20&geo=-122.919|37.27489|-121.919|38.27489", Root.class);
		System.out.println(lotinfo.toString());
	}

	@Test
	public void testLots() {
		//Root lotinfo = HttpReqClient.getReqProxy(HostEnum.PARKME_HOST_LOTS,"pub_id=3f1dc7ee&chk=264e2dd5847bd29d1819aa4993ffae21&det=1&bbox=-122.919|37.27489|-121.919|38.27489&max=20&geo=-122.919|37.27489|-121.919|38.27489", Root.class);
		//System.out.println(lotinfo.toString());
	}
	
	@Test
	public void testExcheng() throws Exception
	{
		GooglePlaceResult gpr = new GooglePlaceResult();
		gpr.setStatus("status");
		gpr.setHtml_attributions(new String[]{"string"});
		gpr.setNext_page_token("next_page_token");
		List<GooglePlace> results = new ArrayList<GooglePlace>();
		GooglePlace gp = new GooglePlace();
		gp.setVicinity("vicinity");
		GooglePlace gp1 = new GooglePlace();
		gp1.setVicinity("vicinity");
		results.add(gp);
		results.add(gp1);
		gpr.setResults(results);
	
		MultiValueMap<String, String> urlVariables = new LinkedMultiValueMap<String, String>();
		urlVariables.add("userId", "123");
		HttpHeaders headers = new HttpHeaders();
		System.out.println(JsonUtils.obj2json(gpr));
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		List results1 = HttpReqClient.excangeReqProxy(gpr, headers, HttpMethod.PUT, URI.create("http://54.84.220.101:8080/poi/google/recommendations?userId=123"), List.class);
		System.out.println(results1.toString());
		List<GooglePlace> gpL= JsonUtils.json2list(results1.toString(), GooglePlace.class);
		for(GooglePlace gpf : gpL)
		{
			System.out.println(gpf.getVicinity());
		}
		System.out.println(gpL.toString());
	}
	@Test public void testPutMetheds2() throws Exception{
		GooglePlaceResult gpr = new GooglePlaceResult();
		gpr.setStatus("status");
		gpr.setHtml_attributions(new String[]{"string"});
		gpr.setNext_page_token("next_page_token");
		List<GooglePlace> results = new ArrayList<GooglePlace>();
		GooglePlace gp = new GooglePlace();
		gp.setVicinity("vicinity");
		GooglePlace gp1 = new GooglePlace();
		gp1.setVicinity("vicinity");
		results.add(gp);
		results.add(gp1);
		gpr.setResults(results);
	
		MultiValueMap<String, String> urlVariables = new LinkedMultiValueMap<String, String>();
		urlVariables.add("userId", "123");
		HttpHeaders headers = new HttpHeaders();
		System.out.println(JsonUtils.obj2json(gpr));
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//HttpEntity<String> requestEntity = new HttpEntity<String>(JsonUtils.obj2json(gpr),headers);
		HttpEntity<GooglePlaceResult> requestEntity = new HttpEntity<GooglePlaceResult>(gpr
				,headers);
		//HttpReqClient.getRestTemplate().exchange("http://54.84.220.101:8080/poi/google/recommendations?userId=123", 
		//		HttpMethod.PUT, requestEntity, GooglePlaceResult.class, urlVariables);
		
		/*try
		{
			ResponseEntity<List> resultss = HttpReqClient.getRestTemplate().exchange("http://54.84.220.101:8080/poi/google/recommendations?userId=123", 
					HttpMethod.PUT, requestEntity, List.class);
			System.out.println(resultss.getBody().toString());
		}catch(HttpClientErrorException e)
		{
			System.out.println(e.getResponseBodyAsString());
		}*/
		
		RequestEntity<GooglePlaceResult> requestPutEntity  = new RequestEntity<GooglePlaceResult>(gpr,headers, HttpMethod.PUT, URI.create("http://54.84.220.101:8080/poi/google/recommendations?userId=123"));
		try
		{
			@SuppressWarnings("rawtypes")
			ResponseEntity<ErrorRoot> resultss = HttpReqClient.getRestTemplate().exchange(requestPutEntity, ErrorRoot.class);
			List<GooglePlace> gpL= JsonUtils.json2list(resultss.getBody().toString(), GooglePlace.class);
			for(GooglePlace gpf : gpL)
			{
				System.out.println(gpf.getVicinity());
			}
			System.out.println(resultss.getBody());
		}catch(HttpClientErrorException e)
		{
			System.out.println(e.getResponseBodyAsString());
		}
	}
	@Test public void testPutMetheds1(){
		String requestStr = "{"
				+ "\"html_attributions\": ["
				+ "\"string\"],"
				+ "\"next_page_token\": \"string\","
				+ "\"results\": ["
				+ "{"
				+ "\"alt_ids\": ["
				+ "{"
				+ "\"place_id\": \"string\","
				+ "\"scope\": \"string\""
				+ "}"
				+ "],"
				+ "\"formatted_address\": \"string\","
				+ "\"geometry\": {"
				+ "\"location\": {"
				+ "\"lat\": 0,"
				+ "\"lng\": 0"
						+ "}"
						+ "},"
						+ "\"html_attributions\": [null],"
						+ "\"icon\": \"string\","
						+ "\"name\": \"string\","
						+ "\"opening_hours\": {"
						+ "\"open_now\": true},"
						+ " \"photos\": [{"
						+ "\"height\": 0,"
						+ "\"html_attributions\": [\"string\"],"
						+ "\"photo_reference\": \"string\","
						+ "\"width\": 0}],"
						+ "\"place_id\": \"string\","
						+ "\"price_level\": 0,"
						+ "\"rating\": 0,"
						+ "\"scope\": \"string\","
						+ "\"types\": [\"string\"],"
						+ "\"vicinity\": \"string\"}],"
						+ "\"status\": \"string\"}";
		MultiValueMap<String, String> urlVariables = new LinkedMultiValueMap<String, String>();
		urlVariables.add("userId", "123");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		//headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestStr,headers);
		try
		{
			ResponseEntity<String> results = restTemplate.exchange("http://54.84.220.101:8080/poi/google/recommendations?userId=123", 
					HttpMethod.PUT, requestEntity, String.class, urlVariables);
			System.out.println(results.getBody());
		}catch(HttpClientErrorException e)
		{
			System.out.println(e.getResponseBodyAsString());
		}
		
		//restTemplate.put("http://54.84.220.101:8080/poi/google/recommendations", null, urlVariables);
	}
	
	
	
	@Test
	public void testPostQuerry() {
		try
		{
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
			
			body.add("entry_time", "2015-12-12T16:00");
			body.add("duration", "60");
			body.add("f_id", "105280");
			body.add("action", "Reserve");
			body.add("pk_reservation_product", "28cf38a1-0c15-4eac-8a91-6753e2b8922d");
			
		}
		catch(HttpStatusCodeException  e)
		{
			System.out.println(e.getStatusCode() + " "+ e.getStatusText());
		}
	}
}
