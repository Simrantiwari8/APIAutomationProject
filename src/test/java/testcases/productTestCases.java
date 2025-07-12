package testcases;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.*;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;
import pojo.Products;
import routes.Routes;


public class productTestCases extends baseClass {
	
	 @Test
	    public void getAllProducts() {
	        given()
	        .when()
	            .get(Routes.getAllProducts)
	        .then()
	            .statusCode(200)
	            .contentType(ContentType.JSON);
	    }

	    @Test
	    public void getSingleProduct() {
	    	int prodId =configReader.getIntProperty("Productid");
	        given()
	            .pathParam("id", prodId)
	        .when()
	            .get(Routes.getSingleProduct)
	        .then()
	            .statusCode(200)
	            .body("id", equalTo(1));
	    }

	    @Test
	    public void addNewProduct() {
	        Products product = Payload.productPayload();
	        given()
	            .contentType(ContentType.JSON)
	            .body(product)
	        .when()
	            .post(Routes.addNewProduct)
	        .then()
	            .statusCode(200)
	            .body("title", equalTo(product.getTitle())).log().all();
	    }

	    @Test
	    public void UpdateProduct() {
	    	  Products product = Payload.productPayload();
	    	  int prodId =configReader.getIntProperty("Productid");
	        given()
	        .pathParam("id", prodId)
	            .contentType(ContentType.JSON)
	            .pathParam("id",prodId)
	            .body(product)
	        .when()
	            .put(Routes.updateProduct)
	        .then()
	            .statusCode(200)
	            .body("title", equalTo(product.getTitle()));
	    }

	    @Test
	    public void deleteProduct() {
	    	 int prodId = configReader.getIntProperty("Productid");
	    	    given()
	    	        .pathParam("id", prodId)
	    	    .when()
	    	        .delete(Routes.deleteProduct)
	    	    .then()
	    	        .statusCode(200)
	    	        .body("id", equalTo(prodId));
	    	    System.out.println("Product with ID " + prodId + " deleted successfully.");
	    }
	    
	    @Test
	    public void sortedProduct() {
	       Response res = given()
//	    		   .queryParam("sort", "desc")
	            .pathParam("sort", "desc")
	        .when()
	            .get(Routes.getSortedProducts)
	        .then()
	            .statusCode(200)
	            .extract().response();
	       
	      List<Integer> prodId = res.jsonPath().getList("id", Integer.class);
	      System.out.println(prodId);
	      
	      // Verify that the list is sorted in descending order
	      List<Integer> sorted = new ArrayList<>(prodId);
	      sorted.sort(Collections.reverseOrder());
	      Assert.assertEquals(sorted, prodId, "Product IDs are not in descending order");
	      
	  }
	    
	    @Test
	    public void getLimitedProducts() {
	    	int limit =configReader.getIntProperty("limit");
	                given()
	        		.pathParam("limit", limit)
	        .when()
	            .get(Routes.getLimitedProducts)
	        .then()
	            .statusCode(200)
	            .log().all();
	    }
	    }
