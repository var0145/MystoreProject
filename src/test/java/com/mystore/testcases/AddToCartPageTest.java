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
import com.mystore.pageobjects.ProductDetailPage;
import com.mystore.pageobjects.SearchProductPage;

/**
 * 
 */
public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchProductPage searchProductPage;
	ProductDetailPage productDetailPage;
	
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
	@Test(groups={"Regression","Sanity"})
	public void AddToCartTest() throws InterruptedException
	{
		indexPage = new IndexPage();
		searchProductPage= indexPage.clickonProductMenu();
		searchProductPage= indexPage.SearchProduct("T-shirt");
		Thread.sleep(2000);
		productDetailPage= searchProductPage.viewProduct();
		Thread.sleep(1000);
		
	}

}
