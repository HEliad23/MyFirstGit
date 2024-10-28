package saucedemo.com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import saucedemo.com.pageobjects.LoginPage;
import saucedemo.com.pageobjects.ProductsPage;

public class FilterTest extends BaseTest {
	
	@Test
	public void TC01_LoginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");
		String expected = "Products";
		String actual = lp.titleName();
		assertEquals(actual, expected);
	}
	//filter
	@Test
	public void TC02_FilterTest() {
	ProductsPage psp = new ProductsPage(driver);
	psp.FilterResult(1);
	String act = psp.GetFilterName();
	String exp = "Name (Z to A)";
	assertEquals(act, exp);
	}
	
	//first result
	@Test
	public void TC03_FilterTestResult() {
	ProductsPage psp = new ProductsPage(driver);
	psp.FilterResult(1);
	assertTrue(psp.FirstResult("Test.allTheThings() T-Shirt (Red)"));
	assertTrue(psp.LastResult("Sauce Labs Backpack"));
	}
	
	@Test
	public void TC04_FilterOrderResult() {
	ProductsPage psp = new ProductsPage(driver);
	psp.FilterResult(1);
	assertTrue(psp.ZaReultsOrder());
	}
	
	@Test
	public void TC05_FilterOrderResult() {
	ProductsPage psp = new ProductsPage(driver);
	psp.FilterResult(0);
	assertTrue(psp.AzReultsOrder());
	}
}
