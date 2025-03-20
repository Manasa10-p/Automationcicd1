package Seleniumlearning.Manasaproject2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.Abstractcomponents.Abstract;

public class productCatalogue extends Abstract {

	WebDriver driver;

	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(css = ".product")
	List<WebElement> products;

	public List<WebElement> getProductList() {

		return products;

	}

	public WebElement getProductName(String ProductName) {

		WebElement prod = products.stream()
				.filter(s -> s.findElement(By.cssSelector("h4")).getText().equals(ProductName
						)).findFirst()
				.orElse(null);
		return prod;
	}

	public CartPage addToCart(String ProductName) {
		WebElement prod = getProductName(ProductName);
		
		prod.findElement(By.cssSelector(".product-action button:last-of-type")).click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}

}
