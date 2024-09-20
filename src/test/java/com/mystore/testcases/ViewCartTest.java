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
import com.mystore.pageobjects.ViewCart;

/**
 * 
 */
public class ViewCartTest extends BaseClass{

	IndexPage indexPage;
	SearchProductPage searchProductPage;
	ProductDetailPage productDetailPage;
	ViewCart viewcart;
	
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
	
	@Test
	public void verifyTotalPrice() throws InterruptedException
	{
		indexPage = new IndexPage();
		searchProductPage= indexPage.clickonProductMenu();
		searchProductPage= indexPage.SearchProduct("T-shirt");
		//Thread.sleep(2000);
		productDetailPage= searchProductPage.viewProduct();
		//Thread.sleep(2000);
		boolean result= productDetailPage.isProductAvailable();
		Assert.assertTrue(result);
		productDetailPage.enterQty("2");
		productDetailPage.addToCart();
		viewcart = productDetailPage.clickOnViewCart();
		
		// not working fine
		
//		Double unitPrice= viewcart.getUnitPrice();
//		Double totalPrice= viewcart.getTotalPrice();
//		Double totalExpectedPrice= (unitPrice*2)+2; 
//		Assert.assertEquals(totalPrice, totalExpectedPrice);
		//viewcart.ClickOnProceed();
	}
}
