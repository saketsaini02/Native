package org.com.restapitest.restapi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {
	
	@Test
	public void testnumberOfCirCuits2017()
	{
	  given().when().get("https://ergast.com/api/f1/2021/circuits.json").then().assertThat().
	  statusCode(200).
	  and().
	  body("MRData.CircuitTable.Circuits.circuitsId",hasSize(20)).
	  and().
	  header("Cache-Control",equalTo("public, max-age=300"));
	  
	  
	} 
}
