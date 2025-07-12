package testcases;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import routes.Routes;
import utils.ConfigReader;

import org.testng.annotations.BeforeClass;

import routes.Routes;

public class baseClass {
	
	ConfigReader configReader;
	
	 //For logging
	RequestLoggingFilter requestLoggingFilter;
	ResponseLoggingFilter responseLoggingFilter;
	
	
	@BeforeClass
	public void setup() throws FileNotFoundException {
		
		RestAssured.baseURI = Routes.baserUrl;
		configReader = new ConfigReader();  //Config call 
		 
		// Setup filters for logging
	    FileOutputStream fos = new FileOutputStream(".\\logs\\test_logging.log");
	    PrintStream log = new PrintStream(fos, true);
	    
	    requestLoggingFilter = new RequestLoggingFilter(log);
	    responseLoggingFilter = new ResponseLoggingFilter(log);
	    
	    RestAssured.filters(requestLoggingFilter, responseLoggingFilter);
	    
	 
	 
	}
}
