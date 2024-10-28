package saucedemo.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	@FindBy (css = ".title")
	private WebElement title;
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public String GetTitle() {
	return title.getText();
	}
	
}
