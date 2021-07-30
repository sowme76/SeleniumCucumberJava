package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.LoggerUtil;
import utilities.WaitUtil;

public class DeclareReviewPage {
	
	static Logger log =  LoggerUtil.getLogger(DeclareReviewPage.class);

	WebDriver driver;

	public DeclareReviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By declare_tab = By.xpath("//*[contains(text(),'Declare & Review')]");
	By consent_checkbox = By.xpath("react-declaration-consent_acknowledgement_check");
	By question1_option= By.name("react-declaration-criminal_liability_check");
	By question2_option=By.name("react-declaration-civil_proceeding_check");
	By question3_option=By.name("react-declaration-insolvency_proceeding_check");
	By question4_option=By.name("react-declaration-project_incentives_check");
	By question5_option=By.name("react-declaration-other_incentives_check");
	By question6_option= By.name("react-declaration-project_commence_check");
	By question7_option=By.name("react-declaration-related_party_check");
	By question8_option=By.name("react-declaration-debarment_check");
	By question9_option=By.name("react-declaration-covid_safe_check");
	By question10_option=By.name("react-declaration-covid_safe_ques_check");
	By radio1_option= By.id("react-declaration-criminal_liability_check-true");
	By radio2_option=By.id("react-declaration-civil_proceeding_check-true");
	By radio3_option=By.id("react-declaration-insolvency_proceeding_check-true");
	By radio4_option=By.id("react-declaration-project_incentives_check-true");
	By radio5_option=By.id("react-declaration-other_incentives_check-true");
	By radio6_option= By.id("react-declaration-project_commence_check-true");
	By radio7_option=By.id("react-declaration-related_party_check-true");
	By radio8_option=By.id("react-declaration-debarment_check-true");
	By radio9_option=By.id("react-declaration-covid_safe_check-true");
	By radio10_option=By.id("react-declaration-covid_safe_ques_check-true");
	By text1_field= By.id("react-declaration-criminal_liability_remarks");
	By text2_field= By.id("react-declaration-civil_proceeding_remarks");
	By text3_field= By.id("react-declaration-insolvency_proceeding_remarks");
	By text4_field= By.id("react-declaration-project_incentives-0-name");
	By text5_field= By.id("react-declaration-other_incentives-0-name");
	By text6_field= By.id("react-declaration-project_commence_remarks");
	By text7_field= By.id("react-declaration-related_party_remarks");
	By text8_field=By.id("react-declaration-debarment_remarks");
	By select_checkbox = By.id("react-declaration-consent_acknowledgement_check");
	By form_review = By.id("review-btn");
	
	WaitUtil waitUtil = new WaitUtil();
	

	
	
	public void verifyQuestionsoption(List<String> questionoption) {
		
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		List<WebElement> radios = driver.findElements(question1_option);
		log.info(radios.size());

		for (WebElement radios1 : radios) {
			if (radios1.getAttribute("value").equalsIgnoreCase(questionoption.get(0))) {
				radios1.click();
				
				WebElement radio1 = driver.findElement(radio1_option);
				
				if (radio1.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text1_field).sendKeys("disclose");

		        } else {			
		            log.info("No option is selected");					
		        }
				
			}
		}

		List<WebElement> radios1 = driver.findElements(question2_option);
		log.info(radios1.size());

		for (WebElement radio1 : radios1) {
			if (radio1.getAttribute("value").equalsIgnoreCase(questionoption.get(1))) {
				radio1.click();
				
				WebElement radio2 = driver.findElement(radio2_option);
				
				if (radio2.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text2_field).sendKeys("disclose");

		        } else {			
		            log.info("No option is selected");					
		        }
				
			}
		}

		List<WebElement> radios2 = driver.findElements(question3_option);
		log.info(radios2.size());

		for (WebElement radio2 : radios2) {
			if (radio2.getAttribute("value").equalsIgnoreCase(questionoption.get(2))) {
				radio2.click();
				
				WebElement radio3 = driver.findElement(radio3_option);
				
				if (radio3.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text3_field).sendKeys("disclose");

		        } else {			
		            log.info("No option is selected");					
		        }
			}
		}

		List<WebElement> radios3 = driver.findElements(question4_option);
		log.info(radios3.size());

		for (WebElement radio3 : radios3) {
			if (radio3.getAttribute("value").equalsIgnoreCase(questionoption.get(3))) {
				radio3.click();
				
				WebElement radio4 = driver.findElement(radio4_option);
				
				if (radio4.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text4_field).sendKeys("disclose");
//		            TO implement Enter date

		        } else {			
		            log.info("No option is selected");					
		        }
			}
		}

		List<WebElement> radios4 = driver.findElements(question5_option);
		log.info(radios4.size());

		for (WebElement radio4 : radios4) {
			if (radio4.getAttribute("value").equalsIgnoreCase(questionoption.get(4))) {
				radio4.click();
				WebElement radio5 = driver.findElement(radio5_option);
				if (radio5.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text5_field).sendKeys("disclose");
//		            TO implement Enter date

		        } else {			
		            log.info("No option is selected");					
		        }
			}
		}
		
		List<WebElement> radios5 = driver.findElements(question6_option);
		log.info(radios5.size());

		for (WebElement radio5 : radios5) {
			if (radio5.getAttribute("value").equalsIgnoreCase(questionoption.get(5))) {
				radio5.click();
				
				WebElement radio6 = driver.findElement(radio6_option);
				
				if (radio6.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text6_field).sendKeys("disclose");
//		            TO implement Enter date

		        } else {			
		            log.info("No option is selected");					
		        }
			}
		}
		List<WebElement> radios6 = driver.findElements(question7_option);
		log.info(radios6.size());

		for (WebElement radio6 : radios6) {
			if (radio6.getAttribute("value").equalsIgnoreCase(questionoption.get(6))) {
				radio6.click();
				WebElement radio7 = driver.findElement(radio7_option);
				
				if (radio7.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text7_field).sendKeys("disclose");
//		            TO implement Enter date

		        } else {			
		            log.info("No option is selected");					
		        }
			}
		}
		
		List<WebElement> radios7 = driver.findElements(question8_option);
		log.info(radios7.size());

		for (WebElement radio7 : radios7) {
			if (radio7.getAttribute("value").equalsIgnoreCase(questionoption.get(7))) {
				radio7.click();
				WebElement radio8 = driver.findElement(radio8_option);
				if (radio8.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text8_field).sendKeys("disclose");
//		            TO implement Enter date

		        } else {			
		            log.info("No option is selected");					
		        }
			}
		}
		
		List<WebElement> radios8 = driver.findElements(question9_option);
		log.info(radios8.size());

		for (WebElement radio8 : radios8) {
			if (radio8.getAttribute("value").equalsIgnoreCase(questionoption.get(8))) {
				radio8.click();
				
			}
		}
		
		List<WebElement> radios9 = driver.findElements(question10_option);
		log.info(radios9.size());

		for (WebElement radio9 : radios9) {
			if (radio9.getAttribute("value").equalsIgnoreCase(questionoption.get(9))) {
				radio9.click();
			}
		}		

	}

	public void declarereviewtab(String declarereview) {
		driver.findElement(declare_tab).click();	
	}
	
	public void selectcheckbox() {
		driver.findElement(select_checkbox).click();	
	}
	public void clickreview() {
		waitUtil.AllElementvisible(form_review, driver);
		driver.findElement(form_review).click();
		log.info("review button is clicked");
	}
	
	public void verifyMandatoryField(String option) {
	
		
		//waitUtil.AllElementvisible(question1_option, driver);
		driver.navigate().refresh();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> radios = driver.findElements(question1_option);
		log.info(radios.size());

		for (WebElement radios1 : radios) {
			if (radios1.getAttribute("value").equalsIgnoreCase(option)) {
				radios1.click();
				
				WebElement radio1 = driver.findElement(radio1_option);
				
				if (radio1.isSelected()) {					
		            log.info("Yes Option is selected");	
		            driver.findElement(text1_field).sendKeys("disclose");
		            

		        } else {			
		            log.info("No option is selected");					
		        }
				
			}
		}
	}
}