package org.com.restapitest.restapitest_server;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.com.restapitest.client.RestClientModified;
import org.com.restapitest.data.TestBase;
import org.com.restapitest.util.TestUtil;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestServerOrTestModified_GetCall extends TestBase {
	
	TestBase testBase;
	String URL;
	String serviceURL;
	String apiURL;
	RestClientModified restClientModified;
	CloseableHttpResponse closeableHttpResponse;
	String closeableHttpResponseToResponseString;

	CloseableHttpResponse closeableHttpResponseWithHeaders;

	String closeableHttpResponseWithHeadersToResponseString;	
	@BeforeMethod
	public void setUp()
	{
		testBase=new TestBase();
		serviceURL=prop.getProperty("URL");
		apiURL=prop.getProperty("serviceURL");
	    URL= serviceURL+apiURL;
	}
	
	@Test(priority=1)
	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException
	{
		restClientModified=new RestClientModified();
		closeableHttpResponse=restClientModified.get(URL);
		
		
		//Instead of getting Header values from here we can get it from a POJO class & then create a hashMap reference inside while
		//adding all key-values & then use the hashMap reference to
		
		HashMap<String,String> headerInputs=new HashMap<String,String>();
		headerInputs.put("user", "saket");
		headerInputs.put("key", "1234");
		

		closeableHttpResponseWithHeaders=restClientModified.get(URL,headerInputs);
		
		
		
		
		int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code - "+statusCode);
		Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200,200);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//Either use RESPONSE_STATUS_CODE_200 from properties file & use prop.getProperty("RESPONSE_STATUS_CODE_200") or declare it as protected
		//static final int RESPONSE_STATUS_CODE_200=200, or use as public int RESPONSE_STATUS_CODE_200=200 
		//The reason why protected is used as because 
		
		Header[] allHeaders = closeableHttpResponse.getAllHeaders();
	    HashMap<String,String> hashMap=new HashMap<String,String>();
	    for(Header header:allHeaders) //Incorrect to write like, for(Header header:allHeaders[]) 
	    	//allHeaders.entrySet() should not be used as it is of type Header not HashMap
	    	{
	    		hashMap.put(header.getName(), header.getValue());  
	    		//Make sure we have here getName() & getValue() instead getKey() & getValue
	    		//So these methods are coming from "String org.apache.http.NameValuePair.getName()"
	      	}
	    System.out.println("All Headers - "+allHeaders);//prints address
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		try {
	    	closeableHttpResponseToResponseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("CloseableHttpResponse(String UTF8 Format) - "+closeableHttpResponseToResponseString);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			//EntityUtils is Static Helper from Apache //COming from package EntityUtils.toString
			//toString method overridden in EntityUtils class
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObjectResponse=new JSONObject(closeableHttpResponseToResponseString);
	    System.out.println("JSON Object - "+jsonObjectResponse);
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	    
	    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>
	    //Instead of using Naveen's String manipulation we can use like this as well
	    Object DemoTest1 = jsonObjectResponse.get("per_page");
	    
	    //Object DemoTest1 = jsonObjectResponse.getString("per_page"); If we use	    
	    //FAILED: getAPITest
	    //org.json.JSONException: JSONObject["per_page"] is not a string at org.json.JSONObject.wrongValueFormatException
	    System.out.println(DemoTest1);
	  	    
	    JSONObject DemoTest2 = (JSONObject) jsonObjectResponse.getJSONArray("data").get(0);
	    Object last_name = DemoTest2.getString("last_name");
	    //org.json.JSONObject.getString("String")->returns String or  //org.json.JSONObject.get("String")-returns Object
	    System.out.println(last_name);
	    //Whenever we do SYSO "to.String" auto-appended. 
		
	    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>
	    
	    
	    
		//Single Value Assertion
		//perpage
		String perPageValue=TestUtil.getValueByJPath(jsonObjectResponse,"/per_page");
		System.out.println("PerPage - "+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		//totalvalue
		String totalValue=TestUtil.getValueByJPath(jsonObjectResponse,"/total");
		System.out.println("TotalValue - "+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue),12 );

		//JSON Array Value Assertion
		String lastName=TestUtil.getValueByJPath(jsonObjectResponse,"/data[0]/last_name");
		System.out.println("LastName - "+lastName);
		Assert.assertEquals(lastName,"Bluth");

	}

	@Test(priority=2)
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException
	{

		//Instead of getting Header values from here we can get it from a POJO class & then create a hashMap reference inside while
		//adding all key-values & then use the hashMap reference to
		
		HashMap<String,String> headerInputs=new HashMap<String,String>();
		headerInputs.put("user", "saket");
		headerInputs.put("key", "1234");
		
		restClientModified=new RestClientModified();
		closeableHttpResponseWithHeaders=restClientModified.get(URL,headerInputs);
			
		
		int statusCode=closeableHttpResponseWithHeaders.getStatusLine().getStatusCode();
		System.out.println("Status Code - "+statusCode);
		Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200,200);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//Either use RESPONSE_STATUS_CODE_200 from properties file & use prop.getProperty("RESPONSE_STATUS_CODE_200") or declare it as protected
		//static final int RESPONSE_STATUS_CODE_200=200, or use as public int RESPONSE_STATUS_CODE_200=200 
		//The reason why protected is used as because 
		
		Header[] allHeaders = closeableHttpResponseWithHeaders.getAllHeaders();
	    HashMap<String,String> hashMap=new HashMap<String,String>();
	    for(Header header:allHeaders) //Incorrect to write like, for(Header header:allHeaders[]) 
	    	{
	    		hashMap.put(header.getName(), header.getValue());  
	    		//Make sure we have here getName() & getValue() instead getKey() & getValue
	    		//So these methods are coming from "String org.apache.http.NameValuePair.getName()"
	      	}
	    System.out.println("All Headers - "+allHeaders);
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		try {
	    	closeableHttpResponseWithHeadersToResponseString = EntityUtils.toString(closeableHttpResponseWithHeaders.getEntity(), "UTF-8");
			System.out.println("closeableHttpResponseWithHeaders(String UTF8 Format) - "+closeableHttpResponseWithHeadersToResponseString);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			//EntityUtils is Static Helper from Apache //COming from package EntityUtils.toString
			//toString method overridden in EntityUtils class
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObjectResponse=new JSONObject(closeableHttpResponseToResponseString);
	    System.out.println("JSON Object - "+jsonObjectResponse);
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	    
	    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>
	    //Instead of using Naveen's String manipulation we can use like this as well
	    Object DemoTest1 = jsonObjectResponse.get("per_page");
	    
	    //Object DemoTest1 = jsonObjectResponse.getString("per_page"); If we use	    
	    //FAILED: getAPITest
	    //org.json.JSONException: JSONObject["per_page"] is not a string at org.json.JSONObject.wrongValueFormatException
	    System.out.println(DemoTest1);
	  	    
	    JSONObject DemoTest2 = (JSONObject) jsonObjectResponse.getJSONArray("data").get(1);
	    Object last_name = DemoTest2.getString("last_name");
	    //org.json.JSONObject.getString("String")->returns String or  //org.json.JSONObject.get("String")-returns Object
	    System.out.println(last_name);
	    //Whenever we do SYSO "to.String" auto-appended. 
		
	    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>
	    
	    
	    
		//Single Value Assertion
		//perpage
		String perPageValue=TestUtil.getValueByJPath(jsonObjectResponse,"/per_page");
		System.out.println("PerPage - "+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		//totalvalue
		String totalValue=TestUtil.getValueByJPath(jsonObjectResponse,"/total");
		System.out.println("TotalValue - "+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue),12 );

		//JSON Array Value Assertion
		String lastName=TestUtil.getValueByJPath(jsonObjectResponse,"/data[0]/last_name");
		System.out.println("LastName - "+lastName);
		Assert.assertEquals(lastName,"Bluth");

	}

}
//Interview Question-Why instead if we can use static final members in Interface instead use properties file
//Any approach is fine, in the first no need to create a class(However class we cannot create as well) directly Interface name.value
//Second Approach we will use the reference variable created in TestBase but NOT JUST IMPORTING PACKAGE(For creating Object present of
//Class present in different package) BUT ALSO EXTENDING AS WELL to be able to use the already created reference in TestBase class.
