package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;

public class LoginPageSteps {

	private WebDriver driver;
	private LoginPage loginPage;
	private UserAccountPage userAcccountPage;

	private String loginTitle;
	private String userAccountPageTitle;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToSiteURL();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginTitle = loginPage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String titleExpected) {
		Assert.assertTrue(loginTitle.equals(titleExpected));
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		userAcccountPage = loginPage.clickOnLogin();
	}

	@Then("user gets the title of useraccount page")
	public void user_gets_the_title_of_the_next_landing_page_i_e_useraccount_page() {
		userAccountPageTitle = userAcccountPage.getUserAccountPageTitle();
	}

	@Then("useraccount page title should be {string}")
	public void useraccount_page_title_should_be(String expectedTitle) {
		Assert.assertTrue(userAccountPageTitle.equals(expectedTitle));
	}

}
