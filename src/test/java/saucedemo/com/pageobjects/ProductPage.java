package saucedemo.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	@FindBy (css = "#add-to-cart")
	private WebElement addToCart;
	@FindBy (css = "#back-to-products")
	private WebElement backToProducts;
	@FindBy (css = "#remove")
	private WebElement removeBtn;
	@FindBy (css = ".inventory_details_name.large_size")
	private WebElement productName;

	
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void AddToCart(WebElement el) {
	Click(el);
	}
	
	public void AddToCart() {
	Click(addToCart);
	}
	
	public void ReturnToProducts() {
	Click(backToProducts);
	}
	
	public String removeBtnText() {
	return removeBtn.getText();
	}
	
	public String ProductName() {
	return productName.getText();
	}
	
}
