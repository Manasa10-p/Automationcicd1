package Seleniumlearning.Manasaproject2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.Abstractcomponents.Abstract;

public class loginPage extends Abstract {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public productCatalogue goTo() {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		productCatalogue productcatalogue=new productCatalogue(driver);
		return productcatalogue;
	}
	
	
	
}
