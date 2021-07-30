package pages;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.EncodeAndDecodeString;
import utilities.LoggerUtil;
import utilities.WaitUtil;
import org.junit.Assert;

public class LoginPage {
	
	static Logger log =  LoggerUtil.getLogger(LoginPage.class);
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage() {
	}
	
	WaitUtil waitUtil = new WaitUtil();
	EncodeAndDecodeString decode = new EncodeAndDecodeString();
	
	By login_button = By.id("login-button");
	By nric_text = By.name("CPUID");
	By name_text = By.name("CPUID_FullName");
	By uen_text = By.name("CPEntID");
	By role_combo = By.name("CPRole");
	By corppass_login_btn = By.xpath("//button[contains(text(),'Login')][1]");
	By logout_btn = By.id("logout-button");
	By user_text = By.xpath("//*[@id='user-info-item']//div");
	
	// BGP Portal Login
	public void clickBGPLogin() {
		waitUtil.elementToBeClickable(login_button, driver);
		driver.findElement(login_button).click();
	}
	
	public void URL(String url, String encodedUsername, String encodedPassword) {

		EncodeAndDecodeString decode = new EncodeAndDecodeString();
		String username = decode.decodeString(encodedUsername);
		String password = decode.decodeString(encodedPassword);
		String urlWithCreds = "https://" + username + ":" + password + "@" + url;
		System.out.println(urlWithCreds);
		driver.navigate().to(urlWithCreds);

	}
	
	public void enterNRIC(String encodedNRIC) {
		String nric = decode.decodeString(encodedNRIC);
		driver.findElement(nric_text).clear();
		driver.findElement(nric_text).sendKeys(nric);
	}
	
	public void enterName(String name) {
		driver.findElement(name_text).clear();
		driver.findElement(name_text).sendKeys(name);
	}
	
	public void enterUEN(String uen) {
		driver.findElement(uen_text).clear();
		driver.findElement(uen_text).sendKeys(uen);
	}
	
	public void selectRole(String role) {
		Select select = new Select(driver.findElement(role_combo));
		select.selectByValue(role);
	}
	
	public void clickCorppassLogin() {
		driver.findElement(corppass_login_btn).click();
	}
	
	public void clickLogout() {
		driver.findElement(logout_btn).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void verifyLogin(String login) {
		String btnText = driver.findElement(login_button).getText();
		Assert.assertEquals(login, btnText);
		log.info("BGP page displayed with " +btnText+ " button successfully.");
	}
	
	// Name seems to be incorrect in the application.
	public void verifyUserLoggedin() {
		String userText = driver.findElement(user_text).getText();
		Assert.assertNotEquals("",userText);
		log.info("User logged in to Business Grants Portal");
	}

}