package com.ccl;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	WebDriverWait w;
	JavascriptExecutor js;

	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void sendkeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public void selectByVisibleTextDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	public void scrollDownUsingJs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public String getAttributeValue(WebElement element, String attribute) {
		String text = element.getAttribute(attribute);
		return text;
	}
	public void explicitWait(By locator) {
		w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public void quitBrowser() {
		driver.quit();
	}


}
