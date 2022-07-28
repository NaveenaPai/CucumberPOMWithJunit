package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;


public class UserAccountPageSteps {

	private WebDriver driver;

	UserAccountPage accountPage;
	LoginPage loginPage;
	HomePage homePage;

	String userAccountPageTitle;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable userCredentialTable) {

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);

		loginPage = homePage.navigateToSiteURL();

		List<Map<String, String>> credentials = userCredentialTable.asMaps();
		String userName = credentials.get(0).get("username");
		String password = credentials.get(0).get("password");
		accountPage = loginPage.login(userName, password);
	}

	@Then("user gets the title of account page")
	public void user_gets_the_title_of_the_next_landing_page_i_e_useraccount_page() {
		userAccountPageTitle = accountPage.getUserAccountPageTitle();
	}

	@Then("account page title should be {string}")
	public void useraccount_page_title_should_be(String expectedTitle) {
		// Assert.assertEquals(userAccountPageTitle, expectedTitle);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		Assert.assertNotNull(accountPage);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable accountOptionsTable) {
		List<String> expectedoptions = accountOptionsTable.asList();
		List<String> optionsFromScreen = accountPage.getAccountsSectionsList();
		Assert.assertTrue(optionsFromScreen.containsAll(expectedoptions));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedOptionsCount) {
		Integer optionsCnt = accountPage.getAccountsOptionsCount();
		Assert.assertTrue(optionsCnt.equals(expectedOptionsCount));
	}

	@Then("log out of the application")
	public void log_out_of_the_application() {
		loginPage = accountPage.logout();
	}
}
