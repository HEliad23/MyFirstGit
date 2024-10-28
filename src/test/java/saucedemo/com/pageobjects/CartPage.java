package saucedemo.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
	
	@FindBy (css = "#checkout")
	private WebElement checkoutBtn;
	@FindBy (css = ".title")
	private WebElement title;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkout() {
		Click(checkoutBtn);
	}
	
	public String TitleText() {
		return title.getText();
	}
	

}
