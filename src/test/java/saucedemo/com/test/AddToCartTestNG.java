package saucedemo.com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import saucedemo.com.pageobjects.LoginPage;
import saucedemo.com.pageobjects.ProductPage;
import saucedemo.com.pageobjects.ProductsPage;

public class AddToCartTestNG extends BaseTest{

	@Test
	public void TC01_Login() {
		LoginPage lit = new LoginPage(driver);
		lit.Login("standard_user", "secret_sauce");
		String expected = "Products";
		String actual = lit.titleName();
		assertEquals(actual, expected);
	}
	
	@Test
	public void TC02_AddToCart() {
	ProductsPage psp = new ProductsPage(driver);
	psp.AddToCart("Sauce Labs Bolt T-Shirt");
	String expected = "Remove" ;
	ProductPage pp = new ProductPage(driver);
	String actual = psp.AddToCartBtn("Sauce Labs Bolt T-Shirt");
	assertEquals(actual, expected);
	
	}
}
