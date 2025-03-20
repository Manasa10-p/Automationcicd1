package Seleniumlearning.Manasaproject2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.Abstractcomponents.Abstract;

public class CheckoutPage extends Abstract {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//List<WebElement> cardprod = driver.findElements(By.cssSelector(".product-name"));
	
	@FindBy(css = ".product-name")
	List<WebElement> cardprod;
	
	//driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
	//driver.findElement(By.cssSelector(".promoBtn")).click();
	
	@FindBy(css = ".promoCode")
	WebElement promoCode;
	
	@FindBy(css = ".promoBtn")
	WebElement promoBtn;
	
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
	
	By promoInfo=By.cssSelector(".promoInfo");
	//driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeorder;
	
	public Boolean checkProduct(String ProductName) {
		
		Boolean match = cardprod.stream().anyMatch(s -> s.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
public FinalPage promoApply() {
	promoCode.sendKeys("rahulshettyacademy");
	promoBtn.click();
	waitForElementToAppear(promoInfo);
	placeorder.click();
	
	FinalPage finalpage=new FinalPage(driver);
	return finalpage;
	
}
	

}
