package org.com.restapitest.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {
	
	
	public static String getValueByJPath(JSONObject responsejson, String jpath){
		
		Object obj = responsejson;
		//Storing it under Parent reference
		for(String s : jpath.split("/")) 
			//jpath as String type. so split results in String as well,hence storing & iterating it under String type
			if(!s.isEmpty()) 
				//to check for null pointer exception
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
		//casting it to JSONObject so as to use .get() method of JSONObject class
				else if(s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
					//Till above line converting it to JSON Object to use get() & then casting it to JSONArray 
					      .get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		            // once converted to JSONArray now we have to read from the Array with index, so getting index
		return obj.toString();
	}

}




//Hierarchy - Object Class/JSONObject/JSONArray
//Cannot cast from JSONArray to JSONObject