package com.org.miscellenous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DropdownJS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HI");
		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\kavit\\eclipse-workspace\\miscellenous\\Drivers\\geckodriver.exe");

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kavit\\eclipse-workspace\\miscellenous\\Drivers\\chromedriver.exe");
		
		
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver=new ChromeDriver();


	}

}
