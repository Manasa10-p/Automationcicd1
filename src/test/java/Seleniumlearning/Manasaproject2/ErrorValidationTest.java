package Seleniumlearning.Manasaproject2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Seleniumlearning.TestComponents.BaseTest;
import Seleniumlearning.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest{
@Test(groups= {"Error Handling"}, retryAnalyzer=Retry.class)
	public void verifyProduct() throws IOException {

		String ProductName="Brocolli - 1 Kg";
	    //launchapplicaton();	
		productCatalogue productcatalogue = loginpage.goTo();		
		List<WebElement> products = productcatalogue.getProductList();
		WebElement prod = productcatalogue.getProductName(ProductName);
		CartPage cartpage = productcatalogue.addToCart(ProductName);
		CheckoutPage checkoutpage = cartpage.goToCheckoutPage();
		Boolean match = checkoutpage.checkProduct(ProductName);
		Assert.assertTrue(match);
		
		

	

}
}

