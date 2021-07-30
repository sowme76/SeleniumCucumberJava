package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.LoggerUtil;
import utilities.WaitUtil;

public class Proposalpage {
	
	static Logger log =  LoggerUtil.getLogger(Proposalpage.class);
	WebDriver driver;
	
	public Proposalpage(WebDriver driver) {
		this.driver = driver;
	}
	
	WaitUtil wait = new WaitUtil();
	
	By project_title = By.id("react-project-title");
	By project_desc= By.id("react-project-description");
	By activity_dropdown = By.xpath("//div[@class='Select-control']");
	By activity_dropdown_value=By.xpath("//*[starts-with(@id, 'react-select-project-activity--option-')]");
	By target_dropdown=By.xpath("//div[@class='Select-placeholder']");
	By target_dropdown_value=By.xpath("//*[starts-with(@id, 'react-select-project-primary_market--option-')]");
	By proposal_radio = By.name("react-project-is_first_time_expand");
	By date_start_input = By.id("react-project-start_date");
	By start_date = By.xpath("//*[@class='rdtDays']//tbody//td[@class='rdtDay']");
	By start_month_click = By.xpath("//*[@class='rdtDays']//th[@class='rdtSwitch']");
	By start_year_click = By.xpath("//*[@class='rdtMonths']//th[@class='rdtSwitch']");
	By choose_month = By.xpath("//*[@class='rdtMonths']//td[@class='rdtMonth']");
	By choose_year = By.xpath("//*[@class='rdtYears']//td[@class='rdtYear']");
	By date_end_input = By.id("react-project-end_date");
	By end_date = By.xpath("//*[@class='rdtDays']//tbody//td[@class='rdtDay']");
	By proposal_tab = By.xpath("//*[contains(text(),'Proposal')]");
	 
	
	
	public void selectedTab(String section) {
		driver.findElement(proposal_tab).click();
	
	}
	
	public void projecttitle(String projecttitle) {
		driver.findElement(project_title).sendKeys(projecttitle);
	}

	public void projectdescription(String projectdescription) {
		driver.findElement(project_desc).sendKeys(projectdescription);
	}
	
	
	public void selectTarget(String target) {
		driver.findElement(target_dropdown).click();
		List<WebElement> webElement = driver.findElements(target_dropdown_value);
		webElement.size();
		log.info(webElement.size());
		for(WebElement element: webElement) {
			log.info("Text:"+element.getText());
			if(element.getText().equals(target)) {
				element.click();
				break;
		
			}	
		}
		
	}
	
	public void click_proposal_radio(String option) {
		List<WebElement> webElement = driver.findElements(proposal_radio);
		for (WebElement element : webElement) {
			if (element.getAttribute("value").equalsIgnoreCase(option)) {
				element.click();
			}
		}
	}
	
	public void selectStartDate(String date, String month, String year) {
		driver.findElement(date_start_input).click();
		selectYear(year);
		selectMonth(month);
		List<WebElement> elementList = driver.findElements(start_date);
		log.info("Size:"+elementList.size());
		for(WebElement element: elementList) {
			//log.info("Text:"+element.getText());
			if(element.getText().equals(date)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectEndDate(String date, String month, String year) {
		driver.findElement(date_end_input).click();
		selectEndDateYear(year);
		selectMonth(month);
		List<WebElement> elementList = driver.findElements(end_date);
		//int i = 0;
		for(WebElement element: elementList) {
			//i += 1;
			if(element.getText().equals(date)) {
				element.click();
				break;
			}
		}
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void selectMonth(String month) {
		//driver.findElements(start_month_click).get(0).click();
		List<WebElement> elementList = driver.findElements(choose_month);
		for(WebElement element: elementList) {
			log.info("Text:"+element.getText());
			if(element.getText().equals(month)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectYear(String year) {
		driver.findElements(start_month_click).get(0).click();
		driver.findElement(start_year_click).click();
		List<WebElement> elementList = driver.findElements(choose_year);
		for(WebElement element: elementList) {
			log.info("Text:"+element.getText());
			if(element.getText().equals(year)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectEndDateYear(String year) {
		driver.findElements(start_month_click).get(1).click();
		driver.findElement(start_year_click).click();
		List<WebElement> elementList = driver.findElements(choose_year);
		for(WebElement element: elementList) {
			log.info("Text:"+element.getText());
			if(element.getText().equals(year)) {
				element.click();
				break;
			}
		}
	}

	public void proposaltab(String proposaltab) {
		driver.findElement(proposal_tab).click();
	}

	public void activity(String activity) {
		driver.findElement(activity_dropdown).click();
		List<WebElement> webElement = driver.findElements(activity_dropdown_value);
		webElement.size();
		log.info(webElement.size());
		for(WebElement element: webElement) {
			log.info("Text:"+element.getText());
			if(element.getText().equals(activity)) {
				element.click();
				break;
		
			}	
		}
	}
}