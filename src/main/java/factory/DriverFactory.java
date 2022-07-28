package factory;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> threadsafeDriver = new ThreadLocal<>();

	public WebDriver initialize_driver() {

		String browser = ConfigReader.getPropertyValue("browser");

		switch (browser) {
		case "chrome":
			threadsafeDriver.set(WebDriverManager.chromedriver().create());
			break;
		case "firefox":
			threadsafeDriver.set(WebDriverManager.firefoxdriver().create());
			break;
		case "edge":
			threadsafeDriver.set(WebDriverManager.edgedriver().create());
			break;
		default:
			System.out.println("Please pass the correct browser value: " + browser);
			break;
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return threadsafeDriver.get();
	}

}
