/**
 * 
 */
package com.mystore.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;


/**
 * 
 */
public class AccountCreationtPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	//@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp();
		}
	
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void VerifyCreateAccountPageTest() throws Throwable
	{
		indexPage = new IndexPage();
		Thread.sleep(5000);
		loginPage =indexPage.singIn();
		Thread.sleep(5000);
		accountCreationPage = loginPage.createNewAccount("deep", "deep@xyz.com");
		Thread.sleep(5000);
		boolean result= accountCreationPage.validateAccountCreatePage();
		Thread.sleep(5000);
		Assert.assertTrue(result);
	}
	
	
	
}
