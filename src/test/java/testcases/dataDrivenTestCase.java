package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import payloads.Payload;
import pojo.Products;
import routes.Routes;

public class dataDrivenTestCase  extends baseClass {
	
	//Test
	@Test(dataProvider="jsonDataProvider", dataProviderClass=utils.DataProviderUtil.class) // we use this dataProviderClass=utils.DataProviderUtil.class) path to connect with this class 
    public void addNewProduct(Map<String,String> data) {
         
		String title = data.get("title");
		Double price = Double.parseDouble(data.get("price"));
		String category = data.get("category");
		String description = data.get("description");
		String image = data.get("image");
		
      Products product = new Products(title, price,  description, image, category);
	
        given()
            .contentType(ContentType.JSON)
            .body(product)
        .when()
            .post(Routes.addNewProduct)
        .then()
            .statusCode(200)
            .body("title", equalTo(product.getTitle())).log().all();
    }


}
