package org.com.restapitest.restapitest_server;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.com.restapitest.body.Users;
import org.com.restapitest.client.RestClientModified;
import org.com.restapitest.data.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServerOrTestModified_PostCall extends TestBase{

	RestClientModified restClientModified;
	CloseableHttpClient closeableHttpClient ;
	CloseableHttpResponse closeableHttpResponseWithHeaders;
	TestBase testBase;
    String URL;
    String serviceURL;
    Users users;
    String objToJson;
    String apiURL;

//  Setting up Build path need & importance
// <!-- Whatever depeddencies we give here in pom.xml, the jar gets downloaded to Maven Depndencies folder
//    and since the folder is already added to buildpath all of them would be availabe to the Project.
//    //"From https://archive.eclipse.org/eclipse/downloads/documentation/2.0/html/plugins/org.eclipse.jdt.doc.user/reference/ref-123.htm
//    "The build class path is a list of paths visible to the compiler when building the project.
// 
    @BeforeMethod
	public void setUp()
	{
		testBase=new TestBase();
		serviceURL=prop.getProperty("URL");
		apiURL=prop.getProperty("serviceURL");
	    URL= serviceURL+apiURL;
	}
	
    @Test
	public void getPostWithHeaders()
	{
    	//getPost is our implemented method in server or test package, similarly for our Client package we have
    	// our post method implemented. The actual already implemented internal post method that we call is when
    	//we use httpPost(String URL).
    	
    	//I was using like this instead in BeforeTest I was using the below two lines of code
    	//(does not matter though its on us if we write BeforeTest or not)
    	//& most importantly serviceURL & URL was not being initialized so getting
    	//ClientProtocolException.
    	
    	//testBase=new TestBase();
    	//URL=serviceURL+URL;
    	
    	HashMap<String,String> headers=new HashMap<String,String>();
    	headers.put("Content-Type","application/json");
    	headers.put("Accept","application/json");
    	
    	//Jackson API--JSON lint is there,trick Jackson API for marshaling & un-marshaling
    	ObjectMapper objMapper=new ObjectMapper();
    	Users user=new Users("morpheus","leader");
    	
    	//obj to JSON-1ST Technique
    	//trick - we want to write the values in the object to JSON so writeValue()
    	try {
			objMapper.writeValue(new File("C:\\Users\\kavit\\eclipse-workspace\\restapitest\\src\\main\\java\\org\\com\\restapitest\\body\\users.json"),
					             user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//obj to JSONString-2ND Technique
    	
		try {
			objToJson = objMapper.writeValueAsString(user);
			//System.out.println(objToJson);
		} catch (JsonProcessingException e) {
 			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
  
    	restClientModified=new RestClientModified();
    	System.out.println(objToJson);
    	closeableHttpResponseWithHeaders=restClientModified.post(URL, objToJson, headers);
    	//System.out.println(closeableHttpResponseWithHeaders);
    	
    	//closeableHttpResponseWithHeaders.getStatusLine().getStatusCode();
    	
		//after this execution of above post internal method the control comes back here

		
	}

}
