package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import context.TestContextUI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	
	TestContextUI testContextUI;
	public LoginSteps(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Before()
	public void initializeContext() {
		WebDriver driver = null;
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		
		testContextUI.setDriver(driver);
		testContextUI.initializePageObject(driver);
		loginPage = testContextUI.getLoginPage();
	}
	
	LoginPage loginPage = null;
	@Given("Navigate to QA Business Grants Portal using valid URL and credentials {string}{string}{string}")
	public void navigate_to_qa_business_grants_portal_using_valid_url_and_credentials(String url, String username,
			String password) {
		loginPage.URL(url, username, password);
	}

	@Then("Business Grants Portal Login page Should be displayed with login {string}")
	public void business_grants_portal_login_page_should_be_displayed_with_login(String loginText) {
		loginPage.verifyLogin(loginText); 
	}


	@When("Click on login")
	public void click_on_login() {
		loginPage.clickBGPLogin();
	}


	@When("Enter the user NRIC {string}")
	public void enter_the_user_nric(String nric) {
		
		loginPage.enterNRIC(nric);
	}

	@When("Enter the user Name {string}")
	public void enter_the_user_name(String username) {
		loginPage.enterName(username);
	}

	@When("Enter the user UEN {string}")
	public void enter_the_user_uen(String uen) {
		loginPage.enterUEN(uen);
	}

	@When("Select the user Role {string}")
	public void select_the_user_role(String role) {
		loginPage.selectRole(role);
	}

	@When("Click on corppass login")
	public void click_on_corppass_login() {
		loginPage.clickCorppassLogin();
	}

	@Then("User should be able to successfully login to the home page")
	public void user_should_be_able_to_successfully_login_to_the_home_page() {
		loginPage.verifyUserLoggedin();
	}
	
	
	@After(order = 1)
	public void log_out() {
		loginPage.clickLogout();
	}
	@After(order = 0)
	public void close_the_browser() {
		testContextUI.getDriver().quit();
	}
	
}
