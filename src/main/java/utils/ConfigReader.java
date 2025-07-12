package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	 Properties prop;
	public ConfigReader() {
		
		String filepath = ".\\src\\test\\resources\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(filepath); //to read
			prop = new Properties(); 
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Hello");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//This method is use to access the key from config file
     public String getProperty(String key) {
    	 return prop.getProperty(key);
     }
     
   //This method is use to access the key from config file if the value is in integer
     public int getIntProperty(String key) {
    	 return Integer.parseInt(prop.getProperty(key));
     }
     
}
