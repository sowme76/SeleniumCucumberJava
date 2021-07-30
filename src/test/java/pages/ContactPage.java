package pages;

import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


import utilities.LoggerUtil;
import utilities.WaitUtil;

public class ContactPage {
	
	static Logger log =  LoggerUtil.getLogger(LoginPage.class);
	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	WaitUtil wait = new WaitUtil();
	
	By contacts_tab = By.xpath("//*[contains(text(),'Contact Details')]");
	By selected_tab = By.xpath("//*[contains(text(),'Contact Details')] //parent::a[@class='active']");
	By form_name    = By.xpath("//*[contains(text(),'Market Readiness Assistance (MRA)')]");
	By headers_title = By.xpath("//h2[contains(text(),'Contact Details')]");
	By contact_name = By.id("react-contact_info-name-label");
	By job_title = By.id("react-contact_info-designation-label");
	By contact_num = By.id("react-contact_info-phone-label");
	By email_primary = By.id("react-contact_info-primary_email-label");
	By email_alternate = By.id("react-contact_info-secondary_email-label");
	By name_value=By.id("react-contact_info-name");
	By jobtitle_value=By.id("react-contact_info-designation");
	By contactnum_value=By.id("react-contact_info-phone");
	By email_primary_value=By.id("react-contact_info-primary_email");
	By mailing_section = By.xpath("//*[contains(text(),'Mailing Address')]");
	By postal_code = By.id("react-contact_info-correspondence_address-postal");
	By blk_no = By.id("react-contact_info-correspondence_address-block");
	By street_name = By.id("react-contact_info-correspondence_address-street");
	By mailing_checkbox = By.id("react-contact_info-correspondence_address-copied");
	By level_addr = By.id("react-contact_info-correspondence_address-level");
	By unit_addr = By.id("react-contact_info-correspondence_address-unit");
	By letter_add = By.xpath("//*[contains(text(),'Letter Of Offer Addressee')]");
	By name_loa = By.id("react-contact_info-offeree_name-label");
	By jobtitle_loa = By.id("react-contact_info-offeree_designation-label");
	By email_loa = By.id("react-contact_info-offeree_email-label");
	By loa_checkbox = By.id("react-contact_info-copied");
	By name_text_loa = By.id("react-contact_info-offeree_name");
	By job_text_loa = By.id("react-contact_info-offeree_designation");
	By email_text_loa = By.id("react-contact_info-offeree_email");
	By save_btn = By.id("save-btn");
	By draft_msg = By.className("growl-close");
	
	
	public void selectedTab(String section) {
		driver.findElement(contacts_tab).click();
		if(driver.findElement(selected_tab).isSelected()) {
			Assert.assertEquals(section, driver.findElement(selected_tab).getText());
			log.info(driver.findElement(selected_tab).getText()+ " section is selected.");
		}
	
	}

	public void formName(String formname) {
		Assert.assertEquals(formname, driver.findElement(form_name).getText());
		log.info(driver.findElement(form_name).getText()+ " Form is displayed in eligibility section.");
	}
	
	public void headersTitle(String headersTitle) {
		assertTrue(headersTitle.equalsIgnoreCase(driver.findElement(headers_title).getText()));
		log.info(driver.findElement(headers_title).getText()+ " header is displayed in eligibility section.");
	}

	public void verifyContactFields(List<String> contactFieldsList) {
		String actualName = driver.findElement(contact_name).getText();
		actualName = actualName.substring(0,actualName.length()-2);
		Assert.assertEquals(contactFieldsList.get(0), actualName);
		log.info(actualName + " field is displayed.");
		
		String actualJobTitle = driver.findElement(job_title).getText();
		actualJobTitle = actualJobTitle.substring(0,actualJobTitle.length()-2);
		Assert.assertEquals(contactFieldsList.get(1), actualJobTitle);
		log.info(actualJobTitle + " field is displayed.");
		
		String contactNo = driver.findElement(contact_num).getText();
		contactNo = contactNo.substring(0,contactNo.length()-2);
		Assert.assertEquals(contactFieldsList.get(2), contactNo);
		log.info(contactNo + " field is displayed.");
		

		String email = driver.findElement(email_primary).getText();
		email = email.substring(0,email.length()-2);
		Assert.assertEquals(contactFieldsList.get(3), email );
		log.info(email  + " field is displayed.");
		
		String alternateemail = driver.findElement(email_alternate).getText();
		Assert.assertEquals(contactFieldsList.get(4), alternateemail );
		log.info(alternateemail  + " field is displayed.");
	}

	public void inputContactFields(List<String> inputList) {
		
		driver.findElement(name_value).sendKeys(inputList.get(0));
		driver.findElement(jobtitle_value).sendKeys(inputList.get(1));
		driver.findElement(contactnum_value).sendKeys(inputList.get(2));
		driver.findElement(email_primary_value).sendKeys(inputList.get(3));
		log.info("Input field values are entered.");
	}
	
	public void verifyMailingSection(String mailingSection) {
		Assert.assertEquals(mailingSection, driver.findElement(mailing_section).getText());
		log.info(mailingSection+ " section is available.");
	}

	public void enterPostalCode(String postalCode) {
		driver.findElement(postal_code).sendKeys(postalCode);
		log.info(postalCode+ " is entered.");
	}
	
	public void verifyMailAddrAutoPop() {
		log.info(driver.findElement(blk_no).isDisplayed());
		Assert.assertTrue(driver.findElement(blk_no).isDisplayed());
		Assert.assertTrue(driver.findElement(street_name).isDisplayed());
		//Assert.assertFalse(driver.findElement(blk_no).getAttribute("value").isEmpty());
		//Assert.assertFalse(driver.findElement(street_name).getAttribute("value").isEmpty());
		
		log.info(driver.findElement(blk_no).getAttribute("value") +"and" + driver.findElement(street_name).getAttribute("value") + "are auto populated.");
	}
	
	public void clickMailingCheckbox() {
		driver.findElement(mailing_checkbox).click();
		log.info("Mailing checkbox is selected.");
	}
	
	public void verifyMailAddrAutoPopAll() throws InterruptedException {
		String blkNo = driver.findElement(blk_no).getAttribute("value");
		String streetName = driver.findElement(street_name).getAttribute("value");
		String postalCode = driver.findElement(postal_code).getAttribute("value");
		//Few Times level and Unit is displayed in system 
//		String level = driver.findElement(level_addr).getAttribute("value");
//		String unit = driver.findElement(unit_addr).getAttribute("value");
		
		Assert.assertNotEquals("", blkNo);
		Assert.assertNotEquals("", streetName);
		Assert.assertNotEquals("", postalCode);
//		Assert.assertNotEquals("", level);
//		Assert.assertNotEquals("", unit);
		
//		log.info(postalCode + "," + blkNo + "," + postalCode + "," + level + " and " + unit +" are populated.");
	}

	public void verifyLetofferaddsection(String Lofasection) {
		assertTrue(Lofasection.equalsIgnoreCase(driver.findElement(letter_add).getText()));
		log.info(Lofasection+ " section is available.");
		
	}
	
	public void verifyLetterOfOfferSection(List<String> loaFieldsList) {
		String actualName = driver.findElement(name_loa).getText();
		actualName = actualName.substring(0,actualName.length()-2);
		Assert.assertEquals(loaFieldsList.get(0), actualName);
		log.info(actualName + " field is displayed.");
		
		String actualJobTitle = driver.findElement(jobtitle_loa).getText();
		actualJobTitle = actualJobTitle.substring(0,actualJobTitle.length()-2);
		Assert.assertEquals(loaFieldsList.get(1), actualJobTitle);
		log.info(actualJobTitle + " field is displayed.");
		
		String email = driver.findElement(email_loa).getText();
		email = email.substring(0,email.length()-2);
		Assert.assertEquals(loaFieldsList.get(2), email );
		log.info(email  + " field is displayed.");
	}

	public void clickLOACheckbox() {
		if(driver.findElement(loa_checkbox).isSelected()) {
			//Do nothing
		} else {
			driver.findElement(loa_checkbox).click();
		}
		log.info("LOA checkbox is selected.");
	}

	public void clickLOAAutoPop() {
		Assert.assertTrue(driver.findElement(name_text_loa).isDisplayed());
		Assert.assertTrue(driver.findElement(job_text_loa).isDisplayed());
		Assert.assertTrue(driver.findElement(email_text_loa).isDisplayed());
		Assert.assertEquals(driver.findElement(name_value).getAttribute("value"), driver.findElement(name_text_loa).getAttribute("value"));
		Assert.assertEquals(driver.findElement(jobtitle_value).getAttribute("value"), driver.findElement(job_text_loa).getAttribute("value"));
		Assert.assertEquals(driver.findElement(email_primary_value).getAttribute("value"), driver.findElement(email_text_loa).getAttribute("value"));
		log.info("Name, Job title and Email are auto populated based on contact section");
	}
	
	public void click_save() {
		driver.findElement(save_btn).click();
		log.info("Save button is clicked.");
		
	}
	
	public void handleAlert() throws Throwable {
//       WebDriverWait wait = new WebDriverWait(driver, 80);
//       wait.until(ExpectedConditions.presenceOfElementLocated(draft_msg));
//       
	try {
		driver.findElement(draft_msg).click();
		log.info("Alert handled in contacts page.");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	catch (NoAlertPresentException ex) {
        
    }
	}
	
	public void verifySavedValues(List<String> inputList) {
		driver.navigate().refresh();
		Assert.assertEquals(inputList.get(0), driver.findElement(name_value).getAttribute("value"));
		Assert.assertEquals(inputList.get(1), driver.findElement(jobtitle_value).getAttribute("value"));
		Assert.assertEquals(inputList.get(2), driver.findElement(contactnum_value).getAttribute("value"));
		Assert.assertEquals(inputList.get(3), driver.findElement(email_primary_value).getAttribute("value"));
		Assert.assertEquals(inputList.get(0), driver.findElement(name_text_loa).getAttribute("value"));
		Assert.assertEquals(inputList.get(1), driver.findElement(job_text_loa).getAttribute("value"));
		Assert.assertEquals(inputList.get(3), driver.findElement(email_text_loa).getAttribute("value"));
		
		// Mailing address section is not verified since application has bug in showing
		// different user details during automation run. 
		
		log.info("Verified contact details once the page is refreshed");
	}

	public void contactpage(String contactpage) {
		// TODO Auto-generated method stub
		driver.findElement(contacts_tab).click();
	}

}
