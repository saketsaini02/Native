package org.com.restapitest.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClientModified {

	CloseableHttpResponse closeableHttpResponse; 
	//If we initialize the above line inside the method we will have to declare the value else
	//we will have a CTE as initialize variable for the return statement as in this case 
	//closeableHttpResponse will become local to get(), so we have to write like below	
	//CloseableHttpResponse closeableHttpResponse = null; 
	
	//This will be the case even if return statement is not there.
	
	CloseableHttpResponse closeableHttpResponseWithHeaders;
	
	//Get without headers
	public CloseableHttpResponse get(String url)
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		try {
			 closeableHttpResponse=httpClient.execute(httpGet);
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return closeableHttpResponse;
		//The rest body(the part where we are getting the status code,json code,header etc.) we have removed from here as we want fetching
		//to be done in the test case (the method which actually runs) so as validation can be done then & there.
				
	}

	//Get with headers
	public CloseableHttpResponse get(String url,HashMap<String,String> headerMap)
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		
		for(Entry<String, String> entryMap:headerMap.entrySet())
				httpGet.addHeader(entryMap.getKey(), entryMap.getValue());
				
		try {
			 closeableHttpResponseWithHeaders=httpClient.execute(httpGet);
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			return closeableHttpResponseWithHeaders;

	}
	
	//Post with headers
	public CloseableHttpResponse post(String url,String entity,HashMap<String,String> headerMap)
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		try {
			//internal trick to remember adding a String type of Entity(body) so StringEntity
			httpPost.setEntity(new StringEntity(entity));
			// setEntity() receives a  HttpEntity type reference.
			//org.apache.http.client.methods.HttpEntityEnclosingRequestBase.setEntity(HttpEntity entity)
		
			/*
			 * There are three distinct types of entities in HttpCore,depending on where
			 * their content originates:
			 * •streamed: The content is received from a stream,
			 * or generated on the fly. In particular, this category includes entities being
			 * received from a connection. Streamed entities are generally not repeatable.
			 * •self-contained: The content is in memory or obtained by means that are
			 * independent from a connection or other entity.Self-contained entities are
			 * generally repeatable. 
			 * •wrapping: The content is obtained from another entity.
			 */
			
			//Looks like StringEntity type of reference is a wrapped one/To be verified 
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Entry<String, String> entryMap:headerMap.entrySet())
				httpPost.addHeader(entryMap.getKey(), entryMap.getValue());
				
		try {
			 closeableHttpResponseWithHeaders=httpClient.execute(httpPost);
			 //exception occurring at previous line as URL was not correct as we were supposed
			 //to get the URL from PropertyFile but it was not fetched as code only was
			 //not there
			 System.out.println(closeableHttpResponseWithHeaders);
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			return closeableHttpResponseWithHeaders;

	}

}


