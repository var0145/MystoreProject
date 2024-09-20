/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * 
 */
public class LoginPageTest extends BaseClass{
	
		IndexPage indexPage;
		LoginPage loginPage;
		
		//@Parameters("browser")
		@BeforeMethod
		public void setup() {
			launchApp();
			}
		
	
	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(dataProvider= "credentials", dataProviderClass = DataProviders.class, groups= {"smoke","Sanity"})
	public void loginTest(String uname, String pswd)
	{
		indexPage = new IndexPage();
		
		loginPage = indexPage.singIn();
		
		//login using config file
		//indexPage=  loginPage.UserLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		//login using data from excel sheet 
		
		indexPage=  loginPage.UserLogin(uname, pswd);
		
		String actualUrl = indexPage.getCurrUrl();
		String expectedUrl = "https://automationexercise.com/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

}
