package org.com.restapitest.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	protected Properties prop=new Properties();
	//Why protected is needed??? 
	//I believe as a part of good coding practice.
	public TestBase()
	{
		try {
			prop.load(new FileInputStream("C:\\Users\\kavit\\eclipse-workspace\\restapitest\\config.properties"));
			//Providing Project path should also work but not working
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("HI");
		//HI to check if File location is correct
		
	}

	
	protected final static int RESPONSE_STATUS_CODE_200=200;
	protected final static int RESPONSE_STATUS_CODE_500=500;
	protected final static int RESPONSE_STATUS_CODE_400=400;
	protected final static int RESPONSE_STATUS_CODE_401=401;
	protected final static int RESPONSE_STATUS_CODE_201=201;
	
}
