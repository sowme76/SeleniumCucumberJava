package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import utilities.LoggerUtil;
import utilities.WaitUtil;

public class EligibilityPage {

	static Logger log =  LoggerUtil.getLogger(LoginPage.class);

	WebDriver driver;
	WaitUtil wait = new WaitUtil();

	public EligibilityPage(WebDriver driver) {
		this.driver = driver;
	}

	By selected_tab = By.xpath("//*[contains(text(),'Eligibility')]");
	By form_name    = By.xpath("//*[contains(text(),'Market Readiness Assistance (MRA)')]");
	By headers_Title = By.xpath("//h2[text()='Check Your Eligibility']");
	By quest_count = By.xpath("//*[@class='control-label bgp-label']");
	By option_list = By.xpath("//div[@class='controls bgp-radio-text-format']//parent::div");
	By radio_btn = By.xpath("//input[@type='radio']");
	By save_btn = By.id("save-btn");
	By draft_msg = By.className("growl-close");
	By warning_msg = By.className("eligibility-advice");
	By warning_link = By.linkText("FAQ");
	By question1_option= By.name("react-eligibility-sg_registered_check");
	By question2_option=By.name("react-eligibility-turnover_check");
	By question3_option=By.name("react-eligibility-global_hq_check");
	By question4_option=By.name("react-eligibility-new_target_market_check");
	By question5_option=By.name("react-eligibility-started_project_check");
	By radio1_option=By.id("react-eligibility-sg_registered_check-false");
	By radio2_option=By.id("react-eligibility-turnover_check-false");
	By radio3_option=By.id("react-eligibility-global_hq_check-false");
	By radio4_option=By.id("react-eligibility-new_target_market_check-false");
	By radio5_option=By.id("react-eligibility-started_project_check-false");
	By next_btn = By.id("next-btn");
	

	public void selectedTab(String section) {
		if(driver.findElement(selected_tab).isSelected()) {
			Assert.assertEquals(section, driver.findElement(selected_tab).getText());
		}
		log.info(driver.findElement(selected_tab).getText()+ " section is selected.");

	}
	public void formName(String formname) {
		Assert.assertEquals(formname, driver.findElement(form_name).getText());
		log.info(driver.findElement(form_name).getText()+ " Form is displayed in eligibility section.");
	}

	public void headersTitle(String headersTitle) {
		assertTrue(headersTitle.equalsIgnoreCase(driver.findElement(headers_Title).getText()));
		log.info(driver.findElement(headers_Title).getText()+ " header is displayed in eligibility section.");
	}

	public void questCount(int count) {
		List<WebElement> webElement = driver.findElements(quest_count);
		Assert.assertEquals(count, webElement.size());
	}

	public void verifyQuestions(List<String> questionList) {
		List<WebElement> webElement = driver.findElements(quest_count);
		Assert.assertEquals(questionList.get(0), webElement.get(0).getText());
		Assert.assertEquals(questionList.get(1), webElement.get(1).getText());
		Assert.assertEquals(questionList.get(2), webElement.get(2).getText());
		//assertTrue(webElement.get(4).getText().contains(questionList.get(3)));
		log.info("Verified all the questions are displayed as expected.");
	}

	public void verifyOptions() {
		List<WebElement> webElement = driver.findElements(option_list);
		log.info(webElement.get(0).getText());
	}

	public void click_radio(String option) {
		List<WebElement> webElement = driver.findElements(radio_btn);
		for(WebElement element: webElement) {
			if(element.getAttribute("value").equals(option)) {
				element.click();
			}
		}
		log.info("Option selected for all questions.");
	}

	public void clickSave() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(save_btn));
		driver.findElement(save_btn).click();
		log.info("Clicked save button.");
	}

	public void handleAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(draft_msg));
		driver.findElement(draft_msg).click();
		}
		
		catch (NoAlertPresentException ex) {
	        // Alert not present
	        ex.printStackTrace();
	    }
	}

	public void verifySavedValues(String option) {
		driver.navigate().refresh();
		List<WebElement> webElement = driver.findElements(radio_btn);
		for(WebElement element: webElement) {
			if(element.getAttribute("value").equals(option)) {
				Assert.assertEquals(true, element.isSelected());
				log.info("Option is selected as expected.");
			}
		}
	}

	public void verifyWarnMsg(String warnMsg) {
		List<WebElement> webElement = driver.findElements(warning_msg);
		for(WebElement element: webElement) {
			Assert.assertEquals(warnMsg, element.getText());
		}
		log.info("Warning message verified for option NO in eligibility section.");
	}

	public void clickWarnLink() {
		List<WebElement> webElement = driver.findElements(warning_link);
		if(webElement.size() > 0) {
			webElement.get(0).click();
		}
		log.info("Warning link is clicked.");
	}
	public void verifyNewWindow(String url) {
		String parent = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		allHandles.remove(allHandles.iterator().next());
		driver.switchTo().window(allHandles.iterator().next());
		wait.urlContains(url, driver);
		Assert.assertEquals(url, driver.getCurrentUrl());
		log.info("FAQ url:"+driver.getCurrentUrl());

		driver.switchTo().window(parent);

	}

	public void verifyQuestionsoption(List<String> questionoption) {

		List<WebElement> radios = driver.findElements(question1_option);
		log.info(radios.size());

		for (WebElement radios1 : radios) {
			if (radios1.getAttribute("value").equalsIgnoreCase(questionoption.get(0))) {
				radios1.click();
				
			}
		}

		List<WebElement> radios1 = driver.findElements(question2_option);
		log.info(radios1.size());

		for (WebElement radio1 : radios1) {
			if (radio1.getAttribute("value").equalsIgnoreCase(questionoption.get(1))) {
				radio1.click();
			}
		}

		List<WebElement> radios2 = driver.findElements(question3_option);
		log.info(radios2.size());

		for (WebElement radio2 : radios2) {
			if (radio2.getAttribute("value").equalsIgnoreCase(questionoption.get(2))) {
				radio2.click();
			}
		}

		List<WebElement> radios3 = driver.findElements(question4_option);
		log.info(radios3.size());

		for (WebElement radio3 : radios3) {
			if (radio3.getAttribute("value").equalsIgnoreCase(questionoption.get(3))) {
				radio3.click();
			}
		}

		List<WebElement> radios4 = driver.findElements(question5_option);
		log.info(radios4.size());

		for (WebElement radio4 : radios4) {
			if (radio4.getAttribute("value").equalsIgnoreCase(questionoption.get(4))) {
				radio4.click();
			}
		}

	}


	public void verifyWarnNoMsg(String warnMsg) {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement radio1 = driver.findElement(radio1_option);
		
		if (radio1.isSelected()) {					
            log.info("No Option is selected");	
            String Msg2= driver.findElement(warning_msg).getText();
          
       			Assert.assertEquals(warnMsg, Msg2);
           log.info("Warning message verified for option NO in eligibility section.");

        } else {			
            log.info("Yes option is selected");					
        }
		

	WebElement radio2 = driver.findElement(radio2_option);
	
	if (radio2.isSelected()) {					
        log.info("No Option is selected");	
        String Msg2= driver.findElement(warning_msg).getText();
      
   			Assert.assertEquals(warnMsg, Msg2);
       log.info("Warning message verified for option NO in eligibility section.");

    } else {			
    	log.info("Yes option is selected");					
    }
	
	
	
WebElement radio3 = driver.findElement(radio3_option);
	
	if (radio3.isSelected()) {					
        log.info("No Option is selected");	
        String Msg2= driver.findElement(warning_msg).getText();
      
   			Assert.assertEquals(warnMsg, Msg2);
       log.info("Warning message verified for option NO in eligibility section.");

    } else {			
    	log.info("Yes option is selected");					
    }
	
WebElement radio4 = driver.findElement(radio4_option);
	
	if (radio4.isSelected()) {					
        log.info("No Option is selected");	
        String Msg2= driver.findElement(warning_msg).getText();
      
   			Assert.assertEquals(warnMsg, Msg2);
       log.info("Warning message verified for option NO in eligibility section.");

    } else {			
    	log.info("Yes option is selected");					
    }
	
WebElement radio5 = driver.findElement(radio5_option);
	
	if (radio5.isSelected()) {					
        log.info("No Option is selected");	
        String Msg2= driver.findElement(warning_msg).getText();
      
   			Assert.assertEquals(warnMsg, Msg2);
       log.info("Warning message verified for option NO in eligibility section.");

    } else {			
    	log.info("Yes option is selected");					
    }
	
	}
	
	public void nextbtn() {
		driver.findElement(next_btn).click();
		log.info("Clicked Next button.");
	}

}

	
	