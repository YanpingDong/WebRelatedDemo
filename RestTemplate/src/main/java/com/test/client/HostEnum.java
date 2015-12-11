package com.test.client;

public enum HostEnum {
    
	PARKME_HOST_LOTS("http://api.parkme.com/Lots"),
	PARKME_HOST_METERS("http://api.parkme.com/Meters"),
	PARKME_HOST_RESERVATION("https://api.parkme.com/reservation/");
    private String host;
 
    private HostEnum(String host) {
        this.host = host;
    }
 
    public String getRoute() {
        return host;
    }
 
}