package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {

	private WebDriver driver;

	@FindBy(css = "div#center_column span")
	List<WebElement> options;

	@FindBy(className = "logout")
	WebElement logout;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getUserAccountPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsOptionsCount() {
		return options.size();
	}

	public List<String> getAccountsSectionsList() {

		List<String> optionsList = new ArrayList<>();
		for (WebElement e : options) {
			String text = e.getText();
			optionsList.add(text);
		}

		return optionsList;

	}

	public LoginPage logout() {
		logout.click();
		return new LoginPage(driver);
	}

}
