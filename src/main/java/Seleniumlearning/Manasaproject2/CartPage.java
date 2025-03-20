package Seleniumlearning.Manasaproject2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.Abstractcomponents.Abstract;

public class CartPage extends Abstract {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	@FindBy(xpath = "//img[@alt='Cart']")
	WebElement gotocart;
	
	//driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	WebElement gotocheckout;
	
	By producttables=By.id("productCartTables");
	
	public CheckoutPage goToCheckoutPage() {
		
		gotocart.click();
		gotocheckout.click();
		waitForElementToAppear(producttables);
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
	}

	

}
