package pages;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.LoggerUtil;

public class CostPage {
	
	static Logger log =  LoggerUtil.getLogger(DeclareReviewPage.class);

	WebDriver driver;
	

	public CostPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By expand_vendor = By.xpath("//*[@class='accordion-chevron pull-right']");
	By vendor_radio = By.name("react-project_cost-vendors-0-local_vendor");
	By vendor_txt = By.id("react-project_cost-vendors-0-vendor_name");
	By vendor_currency = By.id("react-project_cost-vendors-0-amount_in_billing_currency");
	By select_file_btn = By.id("react-project_cost-vendors-0-attachments-btn");
	By cost_tab = By.xpath("//*[contains(text(),'Cost')]");
	By add_new_item = By.id("react-project_cost-vendors-add-item");
	By upload_file =By.name("react-project_cost-vendors-0-attachments-btn");
	
	public void selectedCostTab(String section) {
		driver.findElement(cost_tab).click();
	}
	
	public void clickExpandVendor() {
		driver.findElements(expand_vendor).get(0).click();
	}
	
	public void clickCostRadio(String option) {
		List<WebElement> webElement = driver.findElements(vendor_radio);
		for (WebElement element : webElement) {
			if (element.getAttribute("value").equalsIgnoreCase(option)) {
				element.click();
			}
		}
	}
	
	public void enterVendorInput(String input) {
		driver.findElement(vendor_txt).sendKeys(input);
	}
	
	public void enterVendorCost(String input) {
		driver.findElement(vendor_currency).sendKeys(input);
	}
	
	public void uploadFile(String input) throws Throwable {
		
		//MAC OS code
		
		driver.findElement(upload_file).click();
		//Copy to clipboard
		  StringSelection ss = new StringSelection("/Users/sowme/Documents/sowmiya/test");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  Robot robot = new Robot();
		//Cmd+Tab
		  robot.keyPress(KeyEvent.VK_META);
		    robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_META);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.delay(1000);

		//Open Goto window
		    robot.keyPress(KeyEvent.VK_META);
		    robot.keyPress(KeyEvent.VK_SHIFT);
		    robot.keyPress(KeyEvent.VK_G);
		    robot.keyRelease(KeyEvent.VK_META);
		    robot.keyRelease(KeyEvent.VK_SHIFT);
		    robot.keyRelease(KeyEvent.VK_G);

		//Paste the clipboard value
		    robot.keyPress(KeyEvent.VK_META);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_META);
		    robot.keyRelease(KeyEvent.VK_V);

		//Press Enter key to close the Goto window and Upload window
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(1000);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		    
		//driver.findElement(select_file_btn).sendKeys("/Users/sowme/Documents/sowmiya/test.docx");
	}
	
	public void addNewItem() {
		driver.findElement(add_new_item).click();	
	}

}
