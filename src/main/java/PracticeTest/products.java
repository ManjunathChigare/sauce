package PracticeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class products {

	public WebDriver driver;

	public products(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	private WebElement About;

	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement menu;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private List<WebElement> itemsPrice;

	@FindBy(xpath = "//div[@class='inventory_item_price']/following-sibling::button[1]")
	private List<WebElement> button;

	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	private WebElement cartButton;

	public WebElement menu() {
		return menu;

	}

	public WebElement About() {

		return About;
	}

	public WebElement itemsPrice() {

		List<WebElement> item = itemsPrice;

		List<WebElement> addCart = button;
		Map<Float, WebElement> map = new HashMap<>();

		for (int i = 0; i <= item.size() - 1; i++) {
			for (int j = 0; j <= addCart.size() - 1; j++) {
				WebElement e = addCart.get(j);

				map.put(Float.valueOf(item.get(i).getText().replaceAll("[$]+", "")), e);

			}

		}
		Float f = Collections.max(map.keySet());
		WebElement a = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		map.put(f, a);
		return map.get(f);

	}

	public yourCart cartButton() {
		cartButton.click();
		yourCart cart=new yourCart(driver);
		return cart;

	}

}
