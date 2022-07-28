package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "email")
	WebElement emailId;
	@FindBy(id = "passwd")
	WebElement password;
	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUserName(String username) {
		emailId.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public UserAccountPage clickOnLogin() {
		signInButton.click();
		return new UserAccountPage(driver);
	}

	public UserAccountPage login(String username, String passwrd) {

		emailId.sendKeys(username);
		password.sendKeys(passwrd);
		signInButton.click();
		return new UserAccountPage(driver);
	}
}
