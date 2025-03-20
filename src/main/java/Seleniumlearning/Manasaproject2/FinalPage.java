package Seleniumlearning.Manasaproject2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Seleniumlearning.Abstractcomponents.Abstract;

public class FinalPage extends Abstract {

	WebDriver driver;

	public FinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Select select = new Select(driver.findElement(By.xpath("//div/select")));
	//select.selectByValue("India");
	
	@FindBy(xpath = "//div/select")
	WebElement selecttext;
	
	//driver.findElement(By.cssSelector(".chkAgree")).click();
	//driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	@FindBy(css = ".chkAgree")
	WebElement chkAgree;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceed;
	
	public void selectdropdown() {
		
		Select select=new Select(selecttext);
		select.selectByValue("India");
	}
	
	public void Confirmation() {
		chkAgree.click();
		proceed.click();
		
	}
	

}
