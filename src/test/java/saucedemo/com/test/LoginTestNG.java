package saucedemo.com.test;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;
import saucedemo.com.pageobjects.LoginPage;
import saucedemo.com.pageobjects.ProductsPage;

	
public class LoginTestNG extends BaseTest {
			
	@Test
	public void TC01_FLoginTest() {
		LoginPage lit = new LoginPage(driver);
		lit.Login("", "");
		String expected = "Epic sadface: Username is required";
		String actual = lit.errorMsg();
		assertEquals(actual, expected);	
	}
	
	@Test(dataProvider="getData")
	public void TC02_FLoginTest(String user, String password) {
		LoginPage lit = new LoginPage(driver);
		lit.Login(user, password);
		String expected = "Epic sadface: Username and password do not match any user in this service"; 
		String actual = lit.errorMsg();
		assertEquals(actual, expected);
	}
	
	@Test
	public void TC03_LoginTest() {
		LoginPage lit = new LoginPage(driver);
		lit.Login("standard_user", "secret_sauce");
		String expected = "Products";
		String actual = lit.titleName();
		assertEquals(actual, expected);
	}
	
	@Test
	public void TC04_ChooseProduct() {
		ProductsPage psp = new ProductsPage(driver);
		psp.AddToCart("Sauce Labs Backpack");
		psp.AddToCart("Sauce Labs Onesie");
		
	}
	
	@DataProvider
	public Object[][] getData(){
			Object[][] myData = {
					{"user1", "secret_sauce"},
					{"user2", "s1"},
					};
			return myData;
			}
	}		
		
			

	