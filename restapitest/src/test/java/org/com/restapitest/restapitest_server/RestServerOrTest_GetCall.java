package org.com.restapitest.restapitest_server;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.com.restapitest.client.RestClient;
import org.com.restapitest.data.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestServerOrTest_GetCall extends TestBase {
	TestBase testBase;
	String URL;
	@BeforeMethod
	public void setUp()
	{
		testBase=new TestBase();
		String serviceURL=prop.getProperty("URL");
		String apiURL=prop.getProperty("serviceURL");
	    URL= serviceURL+apiURL;
	}
	
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
		RestClient restClient=new RestClient();
		restClient.get(URL);
		
	}

}

//Interview Question-Why instead if we can use static final members in Interface instead use properties file
//Any approach is fine, in the first no need to create a class(However class we cannot create as well) directly Interface name.value
//Second Approach we will use the reference variable created in TestBase but NOT JUST IMPORTING PACKAGE(For creating Object present of
//Class present in different package) BUT ALSO EXTENDING AS WELL to be able to use the already created reference in TestBase class.



//RestServerModified shows the recent changes which were made gradually moving up with the code