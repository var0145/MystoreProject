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
import com.mystore.pageobjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends BaseClass{
	
	IndexPage indexPage  = new IndexPage();
	
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
		
		@Test(groups="Smoke")
		public void verifyLogo()
		{
			indexPage  = new IndexPage();
			boolean result= indexPage.validateLogo();
			Assert.assertTrue(result);
		}
		@Test(groups="Smoke")
		public void verfiyTitle()
		{
			String actualtitle = indexPage.getTitle();
			String expectedtitle= "Automation Exercise";
			System.out.println(actualtitle);
			//Assert.assertEquals(acttitle, "Automation Exercise");
			
			Assert.assertEquals(actualtitle, expectedtitle,"title verified");
		}
		
}
