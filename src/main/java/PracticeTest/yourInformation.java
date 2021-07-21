package PracticeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class yourInformation {
	public WebDriver driver;

	public yourInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement ZipCode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement Continue;
	

	public WebElement FirstName() {

		return FirstName;
	}

	public WebElement LastName() {

		return LastName;
	}

	public WebElement ZipCode() {

		return ZipCode;
	}
	
	public CheckOutOverview Continue() {
		Continue.click();
		CheckOutOverview co=new CheckOutOverview(driver);
		return co;
	}
}
