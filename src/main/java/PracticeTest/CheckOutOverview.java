package PracticeTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverview {

	public WebDriver driver;

	public CheckOutOverview(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='title']")
	private WebElement Overview;

	@FindBy(xpath = "//div[@class='summary_total_label']")
	private WebElement TotalPrice;

	public WebElement OverView() {
		return Overview;

	}

	public WebElement TotalPrice() {
	
			return TotalPrice;
		}
		

	
}
