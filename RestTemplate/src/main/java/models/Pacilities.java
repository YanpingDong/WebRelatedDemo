package models;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
public class Pacilities {
private List<Peps> peps ;

public List<Peps> getPeps() {
	return peps;
}
public void setPeps(List<Peps> peps) {
	this.peps = peps;
}
public List<Phone> getPhones() {
	return phones;
}
public void setPhones(List<Phone> phones) {
	this.phones = phones;
}
private int ts;

private int review_count;

private boolean is_open;

private String type;

private String currency;

private List<Phone> phones ;

private int distance;

private int cost_index;

private String name;

private int review_score;

private String note;

private String status;

private String currency_iso;

private int f_id;


private String format;

private String url;

private String operator;

private String tz;

private String address;

private Double[] point ;
public Double[] getPoint() {
	return point;
}
public void setPoint(Double[] point) {
	this.point = point;
}
private String max_request;

public void setTs(int ts){
this.ts = ts;
}
public int getTs(){
return this.ts;
}
public void setReview_count(int review_count){
this.review_count = review_count;
}
public int getReview_count(){
return this.review_count;
}
public void setIs_open(boolean is_open){
this.is_open = is_open;
}
public boolean getIs_open(){
return this.is_open;
}
public void setType(String type){
this.type = type;
}
public String getType(){
return this.type;
}
public void setCurrency(String currency){
this.currency = currency;
}
public String getCurrency(){
return this.currency;
}

public void setDistance(int distance){
this.distance = distance;
}
public int getDistance(){
return this.distance;
}

public void setCost_index(int cost_index){
this.cost_index = cost_index;
}
public int getCost_index(){
return this.cost_index;
}
public void setName(String name){
this.name = name;
}
public String getName(){
return this.name;
}
public void setReview_score(int review_score){
this.review_score = review_score;
}
public int getReview_score(){
return this.review_score;
}
public void setNote(String note){
this.note = note;
}
public String getNote(){
return this.note;
}

public void setStatus(String status){
this.status = status;
}
public String getStatus(){
return this.status;
}
public void setCurrency_iso(String currency_iso){
this.currency_iso = currency_iso;
}
public String getCurrency_iso(){
return this.currency_iso;
}
public void setF_id(int f_id){
this.f_id = f_id;
}
public int getF_id(){
return this.f_id;
}

public void setFormat(String format){
this.format = format;
}
public String getFormat(){
return this.format;
}
public void setUrl(String url){
this.url = url;
}
public String getUrl(){
return this.url;
}
public void setOperator(String operator){
this.operator = operator;
}
public String getOperator(){
return this.operator;
}

public void setTz(String tz){
this.tz = tz;
}
public String getTz(){
return this.tz;
}

public void setAddress(String address){
this.address = address;
}
public String getAddress(){
return this.address;
}

public void setMax_request(String max_request){
this.max_request = max_request;
}
public String getMax_request(){
return this.max_request;
}
@Override
public String toString()
{
	return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
}


}