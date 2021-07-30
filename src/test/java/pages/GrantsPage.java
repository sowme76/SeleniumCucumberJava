package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;

import utilities.LoggerUtil;
import utilities.WaitUtil;

public class GrantsPage {

	WebDriver driver;

	public GrantsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public GrantsPage() {
	}

	static Logger log =  LoggerUtil.getLogger(GrantsPage.class);
	WaitUtil waitUtil = new WaitUtil();

	By my_grants= By.xpath("//div/a[contains(text(),'My Grants')]");
	By select_new_grant = By.xpath("//*[text()='Get new grant']");
	By select_sector = By.xpath("//*[@name='industry_type']");
	//By select_devarea = By.xpath("//*[@name='development_area']");
	By select_devarea=By.xpath("//input[@type='radio']");
	By select_funcarea = By.xpath("//*[@name='functional_grant']");
	By apply_btn = By.id("go-to-grant");
	By check_draft_form = By.xpath("//h1[@class='grant-title above-pkg-label']");
	By proceed_btn = By.id("keyPage-form-button");
	By check_sections = By.xpath("//span[@class='menu-text']");
	By sub_item_list =By.xpath("//ul[@class='sub-item-list']");
	By sub_item_inner_list = By.xpath("//*[@class='sub-item-inner-container']//input[@type='radio']");
	
	public void verifyGrantsPage(String input) {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(my_grants).getText(), input);
		log.info("User is redirected to My Grants page.");
	}
	
	public void clickNewGrant() {
		driver.findElement(select_new_grant).click();
		log.info("User is redirected to Sector page.");
	}
	
	public void selectSector(String sector) {
		List<WebElement> webElements = driver.findElements(select_sector);
		for(WebElement element:webElements) {
			if(element.getAttribute("value").equals(sector)) {
				element.click();
				break;
			}
		}
		log.info("Sector is selected.");
	}
	
	public void selectDevarea(String devarea) {
		//waitUtil.AllElementvisible(select_devarea, driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
			List<WebElement> webElements = driver.findElements(select_devarea);
			for(WebElement element:webElements) {
				if(element.getAttribute("value").equals(devarea)) {		
					element.click();
					log.info("Development area is selected.");
					break;
				}
			}

		}
		
		
	
	
	public void selectFuncarea(String funcarea) {
		
		//waitUtil.AllElementvisible(select_devarea, driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}	
			log.info(driver.findElement(select_funcarea).isSelected());
			List<WebElement> webElements = driver.findElements(select_funcarea);
			
			for(WebElement element:webElements) {
				if(element.getAttribute("value").equals(funcarea))
				{
							element.click();
							log.info("Functional area is selected.");
							break;
					}
					
					
				}
			}
		
		
	
	
	public void clickApply() {
		driver.findElement(apply_btn).click();
		log.info("Applyssss button is clicked.");
	}
	
	public void verifyDraftPage(String formName) {
		String actualFormName = driver.findElement(check_draft_form).getText();
		Assert.assertEquals(formName, actualFormName);
		log.info("Redirected to draft form successfully.");
	}

	public void clickProceed() {
		driver.findElement(proceed_btn).click();
		log.info("Proceed button is clicked.");
	}
	
	public void checkSections(int sectionCount) {
		List<WebElement> webElements = driver.findElements(check_sections);
		Assert.assertEquals(sectionCount, webElements.size());
		log.info("Form contains " + webElements.size() + " sections.");
	}

	public void selectsubitem(String selectSubItem) {
		
		waitUtil.AllElementvisible(sub_item_inner_list, driver);
		List<WebElement> webElements = driver.findElements(sub_item_inner_list);
		log.info("sublistitem"+ webElements.size());
		for(WebElement element:webElements) {
			if(element.getAttribute("value").equals(selectSubItem)) {
				element.click();
				break;
			}
		}
		
		
		
	}
	
}
