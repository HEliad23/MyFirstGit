package saucedemo.com.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import saucedemo.com.pageobjects.CartPage;
import saucedemo.com.pageobjects.CheckoutPage;
import saucedemo.com.pageobjects.LoginPage;
import saucedemo.com.pageobjects.ProductPage;
import saucedemo.com.pageobjects.ProductsPage;

public class BuyProductTestNG extends BaseTest{

	
	
	
	@Test
	public void TC01_Login() {
	LoginPage lit = new LoginPage(driver);
	lit.Login("standard_user", "secret_sauce");
	String expected = "Products";
	String actual = lit.titleName();
	assertEquals(actual, expected);	
	}

	@Test		
	public void TC02_ChooseProduct() {
	ProductsPage psp = new ProductsPage(driver);
	psp.ClickOnProduct("sauce labs backpack");
	String expected = "Sauce Labs Backpack";
	ProductPage pp = new ProductPage(driver);
	String actual = pp.ProductName();
	assertEquals(actual, expected);
	
	}


	@Test
	public void TC03_AtcAndBack1() {
	ProductPage pp = new ProductPage(driver);
	pp.AddToCart();
	String expected1 = "Remove";
	String actual1 = pp.removeBtnText();
	assertEquals(actual1, expected1);
	pp.ReturnToProducts();
	String expected2 = "Products";	
	LoginPage lit = new LoginPage(driver);
	String actual2 = lit.titleName();
	assertEquals(actual2, expected2);
	}
	
	
	@Test	
	public void TC04_ChooseAnotherProduct() {
	ProductsPage psp = new ProductsPage(driver);
	psp.ClickOnProduct("Sauce Labs Onesie");
	String expected = "Sauce Labs Onesie";
	ProductPage pp = new ProductPage(driver);
	String actual = pp.ProductName();
	assertEquals(actual, expected);
	}
	
	@Test
	public void TC05_AtcAndBack2() {
	ProductPage pp = new ProductPage(driver);
	pp.AddToCart();
	String expected = "Remove";
	String actual = pp.removeBtnText();
	assertEquals(actual, expected);
	pp.ReturnToProducts();
	String expected2 = "Products";	
	LoginPage lit = new LoginPage(driver);
	String actual2 = lit.titleName();
	assertEquals(actual2, expected2);
	}
	
			
	@Test
	public void TC06_OpenCart() {
	ProductsPage psp = new ProductsPage(driver);
	psp.OpenCart();
	CartPage cp = new CartPage(driver);
	String expected = "Your Cart";  
	String actual = cp.TitleText();
	assertEquals(actual, expected);
	}

	@Test	
	public void TC07_Checkout() {
	CartPage cp = new CartPage(driver);
	cp.checkout();	
	CheckoutPage cop = new CheckoutPage(driver);
	String expected = "Checkout: Your Information"; 
	String actual = cop.GetTitle();
	assertEquals(actual, expected);
	
	}

			
			
}
