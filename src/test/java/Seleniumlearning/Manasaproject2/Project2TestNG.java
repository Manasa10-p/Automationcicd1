package Seleniumlearning.Manasaproject2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Seleniumlearning.TestComponents.BaseTest;

public class Project2TestNG extends BaseTest{
@Test(dataProvider="getData", groups= {"purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException {
//triggering for Cicd1

		//String ProductName="Brocolli - 1 Kg";
	    //launchapplicaton();	
		productCatalogue productcatalogue = loginpage.goTo();		
		List<WebElement> products = productcatalogue.getProductList();
		WebElement prod = productcatalogue.getProductName(input.get("productName"));
		CartPage cartpage = productcatalogue.addToCart(input.get("productName"));
		CheckoutPage checkoutpage = cartpage.goToCheckoutPage();
		Boolean match = checkoutpage.checkProduct(input.get("productName"));
		Assert.assertTrue(match);
		FinalPage finalpage=checkoutpage.promoApply();
		finalpage.selectdropdown();
		
		
		

	

}


@DataProvider
public Object[][] getData() throws IOException {
	//return new Object[][] {{"Brocolli - 1 Kg"},{"Cucumber - 1 Kg"}};
	
	List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src\\test\\java\\Seleniumlearning\\data\\PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
	
}
}
