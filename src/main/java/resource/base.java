package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class base {
	public WebDriver driver;
	public static Properties prop;

	public SoftAssert softAssertion;
	public WebDriverWait wait;

	public WebDriver initializer() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Manjunath Chigare\\eclipse-workspace\\Practice\\src\\main\\java\\resource\\data.properties");
		prop = new Properties();
		prop.load(fis);
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manjunath Chigare\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		return driver;

	}

	public SoftAssert softAssertion() {
		SoftAssert softAssertion = new SoftAssert();
		return softAssertion;

	}

}
