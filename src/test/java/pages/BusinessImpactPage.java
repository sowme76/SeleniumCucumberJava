package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.LoggerUtil;

public class BusinessImpactPage {
	
	static Logger log =  LoggerUtil.getLogger(DeclareReviewPage.class);

	WebDriver driver;

	public BusinessImpactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By fy_end_date = By.id("react-project_impact-fy_end_date_0");
	By start_date = By.xpath("//*[@class='rdtDays']//tbody//td[@class='rdtDay']");
	By start_month_click = By.xpath("//*[@class='rdtDays']//th[@class='rdtSwitch']");
	By start_year_click = By.xpath("//*[@class='rdtMonths']//th[@class='rdtSwitch']");
	By choose_month = By.xpath("//*[@class='rdtMonths']//td[@class='rdtMonth']");
	By choose_year = By.xpath("//*[@class='rdtYears']//td[@class='rdtYear']");
	By business_impact_tab = By.xpath("//*[contains(text(),'Business Impact')]");
	By overseas_sales_text = By.xpath("//*[starts-with(@id, 'react-project_impact-overseas_sales')]");
	By overseas_invest_text = By.xpath("//*[starts-with(@id, 'react-project_impact-overseas_investments')]");
	By rationale_proj = By.id("react-project_impact-rationale_remarks");
	By tangible_benefits = By.id("react-project_impact-benefits_remarks");
	
	public void selectFYEndDate(String date, String month, String year) {
//       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		driver.findElement(fy_end_date).click();
		selectYear(year);
		selectMonth(month);
		List<WebElement> elementList = driver.findElements(start_date);
		log.info("Size:"+elementList.size());
		for(WebElement element: elementList) {
			log.info("Text:"+element.getText());
			if(element.getText().equals(date)) {
				element.click();
				break;
			}
		}
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
		driver.findElement(start_month_click).click();
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
	
	public void selectedBusinessImpactTab(String section) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(business_impact_tab).click();
	}
	
	public void enterOverseasSales(List<String> salesInput) {
		List<WebElement> webElements = driver.findElements(overseas_sales_text);
		webElements.get(0).sendKeys(salesInput.get(0));
		webElements.get(1).sendKeys(salesInput.get(1));
		webElements.get(2).sendKeys(salesInput.get(2));
		webElements.get(3).sendKeys(salesInput.get(3));
	}
	
	public void enterOverseasInvestments(List<String> investmentsInput) {
		List<WebElement> webElements = driver.findElements(overseas_invest_text);
		webElements.get(0).sendKeys(investmentsInput.get(0));
		webElements.get(1).sendKeys(investmentsInput.get(1));
		webElements.get(2).sendKeys(investmentsInput.get(2));
		webElements.get(3).sendKeys(investmentsInput.get(3));
	}
	
	public void enterRationaleProj(String input) {
		driver.findElement(rationale_proj).sendKeys(input);
	}
	
	public void enterTangibleBenefits(String input) {
		driver.findElement(tangible_benefits).sendKeys(input);
	}
}
