package saucedemo.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FillText(WebElement el, String text) {
	highlightElement(el, "yellow");
	el.clear();
	el.sendKeys(text);
	}
	
	public void Click(WebElement el) {
	highlightElement(el, "red");
	el.click();
	}
	
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color: yellow; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
}
