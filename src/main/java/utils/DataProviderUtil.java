package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	@DataProvider
	public Object[][] jsonDataProvider() throws IOException {
		// Path to your JSON file
		String filePath = ".\\testdata\\product.json";
 
		// Read JSON file and map it to a List of Maps
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> dataList = objectMapper.readValue(new File(filePath),
				new TypeReference<List<Map<String, String>>>() { //TypeReference - this will convert the all objects
				});
         System.out.println(dataList.size());
       
		// Convert List<Map<String, String>> to Object[][]
		Object[][] dataArray = new Object[dataList.size()][]; //we create here Object[][] of this object and passed the size
		for (int i = 0; i < dataList.size(); i++) {
			dataArray[i] = new Object[] { dataList.get(i) };
		}
 
		return dataArray;
	}
}
