package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class GooglePlaceResult {

	private List<GooglePlace> results;
	private String[] html_attributions;
	private String next_page_token;
	private String status;

	public String[] getHtml_attributions() {
		return html_attributions;
	}

	public void setHtml_attributions(String[] html_attributions) {
		this.html_attributions = html_attributions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<GooglePlace> getResults() {
		return results;
	}

	public void setResults(List<GooglePlace> results) {
		this.results = results;
	}

	public String getNext_page_token() {
		return next_page_token;
	}

	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}

}
