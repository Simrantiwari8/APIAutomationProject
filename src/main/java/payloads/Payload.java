package payloads;

import java.util.Random;

import com.github.javafaker.Faker;

import pojo.Products;

public class Payload {
	
	public static Faker faker = new Faker();
	
	public static Random random = new Random();
	
	public static String Categories [] = {"Electronics","Furniture","Home Appliances","Books"};
	
	
	public static Products productPayload() {
		
		String title = faker.commerce().productName();
		
		Double price = Double.parseDouble(faker.commerce().price());
		
		String description = faker.lorem().sentence();
				
		String image = "https://i.pravatar.cc";
		
		System.out.println(Categories);
	   String categories = Categories[random.nextInt(Categories.length)];
	
	   new Products(title,price,description,image,categories); //object -- just for calling constructr
	   
	   return new Products(title,price,description,image,categories);
	}
	

}
