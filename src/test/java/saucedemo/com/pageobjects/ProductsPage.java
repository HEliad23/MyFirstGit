package saucedemo.com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

	@FindBy (css = ".inventory_item_name")
	private List<WebElement> nameItemList;
	
	@FindBy (css = ".shopping_cart_link")
	private WebElement cartBtn;
	
	@FindBy (css = ".inventory_item")
	private List<WebElement> itemList;

	@FindBy (css = ".product_sort_container")
	private WebElement filter;
	
	@FindBy (css = ".inventory_list>.inventory_item:nth-child(1)>.inventory_item_description>.inventory_item_label>a>.inventory_item_name")
	private WebElement firstResult;
	
	@FindBy (css = ".active_option")
	private WebElement nameOfFilter;
	
	@FindBy (css = ".inventory_list>.inventory_item:nth-child(6)>.inventory_item_description>.inventory_item_label>a>.inventory_item_name")
	private WebElement lastResult;
	
	
	
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickOnProduct(String name) {
		List<WebElement> list = nameItemList;
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				Click(el);
				break;
			} 
			
		}
	}
	
	public void OpenCart() {
	Click(cartBtn);
	}
	
	public void AddToCart(String name) {
		List<WebElement> list = itemList;
		for (WebElement el : list) {
			WebElement title = el.findElement(By.cssSelector(".inventory_item_name"));
			if (title.getText().equalsIgnoreCase(name)) {
				WebElement btn = el.findElement(By.cssSelector(".btn_inventory"));
				Click(btn);
			}
		}
		}
	
	public String AddToCartBtn(String name) {
		List<WebElement> list = itemList;
		String btnText = "";
		for (WebElement el : list) {
			WebElement title = el.findElement(By.cssSelector(".inventory_item_name"));
			if (title.getText().equalsIgnoreCase(name)) {
				WebElement btn = el.findElement(By.cssSelector(".btn_inventory"));
				btnText = btn.getText();
			}
		}
		return btnText;
	}
	
	public void FilterResult(int number) {
	Select f = new Select(filter);
	f.selectByIndex(number);
	}
	
	public boolean FirstResult(String nameOfProduct) {
	if (firstResult.getText().equals(nameOfProduct)) {
	return true;	
	}		
	return false;
	}
	
	public boolean LastResult(String nameOfProduct) {
		if (lastResult.getText().equals(nameOfProduct)) {
		return true;	
		}		
		return false;
		}
	
	public String GetFilterName() {
	return nameOfFilter.getText();
	}
	
	public boolean ZaReultsOrder() {
		for (int i = 0; i < nameItemList.size() -1; i++) {
			if (nameItemList.get(i).getText().compareTo(nameItemList.get(i+1).getText()) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean AzReultsOrder() {
		for (int i = 0; i < nameItemList.size() -1; i++) {
			if (nameItemList.get(i).getText().compareTo(nameItemList.get(i+1).getText()) > 0) {
				return false;
			}
		}
		return true;
	}
	 

	
}
