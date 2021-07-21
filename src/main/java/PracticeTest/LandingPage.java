package PracticeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement Username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement Login;

	public WebElement Username() {
		return Username;
	}

	public WebElement Password() {
		return Password;
	}
	
	public products Login() {
		Login.click();
		products c=new products(driver);
		return c;
	}

}
