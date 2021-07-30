package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	public void elementToBeClickable(By login_button, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(login_button));
	}

	public void isElementVisible(By user_text, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(user_text));
	}
	
	public void AllElementvisible(By user_text, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(user_text));
	}
	public void urlContains(String user_text, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.urlContains(user_text));
	}
}
