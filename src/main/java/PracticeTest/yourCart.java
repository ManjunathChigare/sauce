package PracticeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class yourCart {
	public WebDriver driver;
	
	public yourCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement yourCart;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkOut;
	
	public WebElement yourCart() {
		return yourCart;
	}
	public yourInformation checkOut() {
		checkOut.click();
		yourInformation info=new yourInformation(driver);
		return info;
	}

}
