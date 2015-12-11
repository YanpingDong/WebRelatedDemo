import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import models.ErrorRoot;
import models.LotInfo;
import models.ParkMeReturn;
import models.Phone;
import models.Root;
import models.meters.MeterRoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.test.client.HostEnum;
import com.test.client.HttpReqClinet;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-context.xml"})
public class RESTClientTest {
	
	@Autowired
    private RestTemplate restTemplate;
    
	@Test
	public void testURI() throws MalformedURLException, URISyntaxException{
		URL url = new URL("http:/www.dyp.com?a=a|b");
		//URLEncoder.encode("http:/www.dyp.com?a=a|b");
		url.toURI();
		System.out.println( url.toString() );
	}
	
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
		Root lotinfo = HttpReqClinet.getReqProxy(HostEnum.PARKME_HOST_LOTS,"pub_id=3f1dc7ee&chk=264e2dd5847bd29d1819aa4993ffae21&det=1&bbox=-122.919|37.27489|-121.919|38.27489&max=20&geo=-122.919|37.27489|-121.919|38.27489", Root.class);
		System.out.println(lotinfo.toString());
	}
	
	
	@Test
	public void testMeters(){
		MeterRoot meterRoot = HttpReqClinet.getReqProxy(HostEnum.PARKME_HOST_METERS,"pub_id=3f1dc7ee&chk=ec5fd76b8b8bdcfa0e2538ca8eb908c5&det=1&bbox=-121.87847319160458|37.329422118761734|-120.87847319160458|38.329422118761734&max=20", MeterRoot.class);
		System.out.println(meterRoot.toString());
	}
	
	
	@Test
	public void testErrorQuerry() {
		try
		{
		MeterRoot meterRoot = HttpReqClinet.getReqProxy(HostEnum.PARKME_HOST_METERS,"chk=ec5fd76b8b8bdcfa0e2538ca8eb908c5&det=1&bbox=-12d1.87847319160458|37.329422118761734|-120.87847319160458|38.329422118761734&max=20", MeterRoot.class);
		System.out.println(meterRoot.toString());
		}
		catch(HttpStatusCodeException  e)
		{
			System.out.println(e.getStatusCode() + " "+ e.getStatusText());
		}
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
			ErrorRoot meterRoot = HttpReqClinet.postReqProxy(HostEnum.PARKME_HOST_RESERVATION, body, ErrorRoot.class);
			System.out.println(meterRoot.toString()+ meterRoot.getError().getErrorDescription());
		}
		catch(HttpStatusCodeException  e)
		{
			System.out.println(e.getStatusCode() + " "+ e.getStatusText());
		}
	}
}
