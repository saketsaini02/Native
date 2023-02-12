package org.com.restapitest.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	private CloseableHttpResponse getResponse;
		
	public void get(String url)
	{
		CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		//CloseableHttpResponse getResponse=null; 
		try {
			 getResponse = closeableHttpClient.execute(httpGet);
			//Create field or create constant????????
			 } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Try catch is also TryCatch or Multi- Try-Catch(As in it will have multi-catch blocks), first one gives two catch blocks
		//in child-parent sequence & the latter one gives only one,Try-Catch block-Only Parent
		
		System.out.println(getResponse);
		//Check what output it gives>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		int statusCode=getResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	    Header[] allHeaders = getResponse.getAllHeaders();
	    HashMap<String,String> hashMap=new HashMap<String,String>();
	    for(Header header:allHeaders) //Incorrect to write like, for(Header header:allHeaders[]) 
	    	{
	    		hashMap.put(header.getName(), header.getValue());  
	    		//Make sure we have here getName() & getValue() instead getKey() & getValue
	    		//So these methods are coming from "String org.apache.http.NameValuePair.getName()"
	      	}
	    
	    	System.out.println(allHeaders);

		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		String responseString=null;
	    try {
			responseString = EntityUtils.toString(getResponse.getEntity(), "UTF-8");
			System.out.println(responseString);
			//EntityUtils is Static Helper from Apache //COming from package EntityUtils.toString
			//toString method overridden in EntityUtils class
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    JSONObject jsonObject=new JSONObject(responseString);
	    System.out.println(jsonObject);

		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
				
	}

}
