package PracticeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resource.base;

public class landing extends base {
	public WebDriver driver;
	public SoftAssert softAssertion;

	@BeforeTest
	public void config() throws IOException {
		driver = initializer();
		driver.get(prop.getProperty("url"));
		softAssertion = softAssertion();

	}

	@Test
	@Parameters({ "fName", "lName", "ZCode" })
	public void homePageNavigation(String fName, String lName, String ZCode) throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.Username().sendKeys(prop.getProperty("Username"));
		lp.Password().sendKeys(prop.getProperty("Password"));
		products p = lp.Login();
		p.menu().click();
		p.About().click();

		softAssertion.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		p.itemsPrice().click();
		yourCart cart = p.cartButton();
		softAssertion.assertEquals(cart.yourCart().getText(), "YOUR CART");
		yourInformation yi = cart.checkOut();
		yi.FirstName().sendKeys("fName");
		yi.LastName().sendKeys("lName");
		yi.ZipCode().sendKeys(String.valueOf(ZCode));
		CheckOutOverview co = yi.Continue();
	
		softAssertion.assertEquals(co.OverView().getText(), "CHECKOUT: OVERVIEW");
		
		//softAssertion.assertEquals(co.TotalPrice().getText().split(" ")[1].replaceAll("[Total:]+", "")),) ;

		softAssertion.assertAll();

	}

}
