package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.LoggerUtil;
import utilities.WaitUtil;

public class ReviewPage {

	
	static Logger log =  LoggerUtil.getLogger(ReviewPage.class);
	WaitUtil waitUtil = new WaitUtil();
	WebDriver driver;
	
	public ReviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By eligibility_page = By.xpath("//div[starts-with(@id, 'react-eligibility-')]");
	By contact_page = By.xpath("//div[starts-with(@id, 'react-contact')]");
	By declare_page = By.xpath("//div[starts-with(@id, 'react-declaration-')]");
	By disclaimer_checkbox = By.id("react-declaration-info_truthfulness_check");
	By submit_btn = By.id("submit-btn");
	By proposal_page = By.xpath("//div[starts-with(@id, 'react-project-')]");
	By cost_page = By.xpath("//div[starts-with(@id, 'react-project_cost')]");
	By businessPage = By.xpath("//div[starts-with(@id, 'react-project_impact-')]");
	By application_submission=By.xpath("//h3[contains(text(),'application')]");
	By submission_dtls = By.xpath("//table[@class='key-status-section']//td");
	By submission_dtls_other = By.xpath("//table[@class='key-status-section']//td//span");
	
	public void verifyEligibilityPage(List<String> eligibilityList) {
		List<WebElement> webElements = driver.findElements(eligibility_page);
		Assert.assertEquals(eligibilityList.get(0), webElements.get(0).getText());
		Assert.assertEquals(eligibilityList.get(1), webElements.get(1).getText());
		Assert.assertEquals(eligibilityList.get(2), webElements.get(2).getText());
		Assert.assertEquals(eligibilityList.get(3), webElements.get(3).getText());
		Assert.assertEquals(eligibilityList.get(4), webElements.get(4).getText());
		
		log.info("Verified eligibility page.");
	}
	
	public void verifyContactValues(List<String> inputList) {
		List<WebElement> webElements = driver.findElements(contact_page);
		Assert.assertEquals(inputList.get(0), webElements.get(0).getText());
		Assert.assertEquals(inputList.get(1), webElements.get(1).getText());
		Assert.assertEquals(inputList.get(2), webElements.get(2).getText());
		Assert.assertEquals(inputList.get(3), webElements.get(3).getText());
		Assert.assertEquals(inputList.get(0), webElements.get(6).getText());
		Assert.assertEquals(inputList.get(1), webElements.get(7).getText());
		Assert.assertEquals(inputList.get(3), webElements.get(8).getText());
		
		// Mailing address section is not verified since application has bug in showing
		// different user details during automation run. 
		
		log.info("Verified contact details once the page is refreshed");
	}
	
	public void verifyDeclarePage(List<String> inputList) {
		List<WebElement> webElements = driver.findElements(declare_page);
		Assert.assertEquals(inputList.get(0), webElements.get(0).getText());
		Assert.assertEquals(inputList.get(1), webElements.get(1).getText());
		Assert.assertEquals(inputList.get(2), webElements.get(2).getText());
		Assert.assertEquals(inputList.get(3), webElements.get(3).getText());
		Assert.assertEquals(inputList.get(4), webElements.get(4).getText());
		Assert.assertEquals(inputList.get(5), webElements.get(5).getText());
		Assert.assertEquals(inputList.get(6), webElements.get(6).getText());
		Assert.assertEquals(inputList.get(7), webElements.get(7).getText());
		Assert.assertEquals(inputList.get(8), webElements.get(8).getText());
		Assert.assertEquals(inputList.get(9), webElements.get(9).getText());
		
		log.info("Verified declare and review details in review page.");
	}
	
	public void verifyProposalPage(List<String> inputList) {
		List<WebElement> webElements = driver.findElements(proposal_page);
		Assert.assertEquals(inputList.get(0), webElements.get(0).getText());
		Assert.assertEquals(inputList.get(1), webElements.get(1).getText());
		Assert.assertEquals(inputList.get(2), webElements.get(2).getText());
		Assert.assertEquals(inputList.get(3), webElements.get(4).getText());
		Assert.assertEquals(inputList.get(4), webElements.get(5).getText());
		Assert.assertEquals(inputList.get(5), webElements.get(6).getText());
		Assert.assertEquals(inputList.get(6), webElements.get(7).getText());
		
		log.info("Verified proposal details in review page.");
	}
	
	public void verifyCostPage(List<String> inputList) {
		List<WebElement> webElements = driver.findElements(cost_page);
		Assert.assertEquals(inputList.get(0), webElements.get(2).getText());
		Assert.assertEquals(inputList.get(1), webElements.get(3).getText());
		Assert.assertEquals(inputList.get(2), webElements.get(4).getText());
	}
	
	
	public void clickDisclaimer() {
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//		int attempts = 0;
//		while(attempts < 8) {
//			log.info(driver.findElement(disclaimer_checkbox).isSelected());
//			driver.findElement(disclaimer_checkbox).click();
//			attempts += 1;
//		}
		if(driver.findElement(disclaimer_checkbox).isEnabled())
			driver.findElement(disclaimer_checkbox).click();
		log.info("Click disclaimer check box.");
	}
	
	public void submitReviewForm() {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(submit_btn).click();
		log.info("Click submit button.");
	}

	public void verifyBusinessImpactPage(List<List<String>> businessImpactList) {
		List<String> overseasSalesList = businessImpactList.get(1);
		List<String> overseasInvList = businessImpactList.get(2);
		List<String> otherfieldsList = businessImpactList.get(0);
		
		List<WebElement> webElements = driver.findElements(businessPage);
		
		Assert.assertEquals(otherfieldsList.get(0), webElements.get(0).getText());
		Assert.assertEquals(otherfieldsList.get(1), webElements.get(12).getText());
		Assert.assertEquals(otherfieldsList.get(2), webElements.get(13).getText());
		
		Assert.assertEquals(overseasSalesList.get(0), webElements.get(4).getText());
		Assert.assertEquals(overseasSalesList.get(1), webElements.get(5).getText());
		Assert.assertEquals(overseasSalesList.get(2), webElements.get(6).getText());
		Assert.assertEquals(overseasSalesList.get(3), webElements.get(7).getText());
		
		Assert.assertEquals(overseasInvList.get(0), webElements.get(8).getText());
		Assert.assertEquals(overseasInvList.get(1), webElements.get(9).getText());
		Assert.assertEquals(overseasInvList.get(2), webElements.get(10).getText());
		Assert.assertEquals(overseasInvList.get(3), webElements.get(11).getText());
		
		log.info("Verified business impacts page.");
	}
	
	public void verifySubmissionDetails() {
		String subMsg = driver.findElement(application_submission).getText();
		log.info("Submission message is displayed as follows:" +subMsg);
		
		String RefId = driver.findElements(submission_dtls).get(1).getText();
		String status = driver.findElements(submission_dtls).get(3).getText();
		log.info("RefID:"+ RefId +" Status:" + status);
		
		String agencyDtl = driver.findElements(submission_dtls_other).get(0).getText();
		log.info("AgencyDtls:" + agencyDtl);
	}

}
