package Seleniumlearning.Manasaproject2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String product="Brocolli - 1 Kg";
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		List<WebElement> products = driver.findElements(By.cssSelector(".product"));
		

		WebElement prod=products.stream().filter(s->s.findElement(By.cssSelector("h4")).getText().equals("Brocolli - 1 Kg")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".product-action button:last-of-type")).click();
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productCartTables")));
		List<WebElement> cardprod=driver.findElements(By.cssSelector(".product-name"));
		Boolean match=cardprod.stream().anyMatch(s->s.getText().equalsIgnoreCase("Brocolli - 1 Kg"));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Select select=new Select(driver.findElement(By.xpath("//div/select")));
		select.selectByValue("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.close();
	
		
		


				}

			}

		
		
	
	


