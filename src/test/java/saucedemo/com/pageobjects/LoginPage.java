package saucedemo.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	@FindBy(css = "#user-name")
	private WebElement usernameField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;
	@FindBy(css = ".title")
	private WebElement title;
	@FindBy (css = "[data-test='error']")
	private WebElement errorText;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void Login(String user, String password){
	FillText(usernameField, user);
	FillText(passwordField, password);
	Click(loginBtn);
	}
	
	public String titleName(){
	return title.getText();
	}
	
	public String errorMsg() {
	return errorText.getText();
	}
	
	
	
}
