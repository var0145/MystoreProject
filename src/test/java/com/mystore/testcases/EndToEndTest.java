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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.CheckOut;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.ProductDetailPage;
import com.mystore.pageobjects.SearchProductPage;
import com.mystore.pageobjects.ViewCart;
import com.mystore.pageobjects.orderSummaryPage;

/**
 * 
 */
public class EndToEndTest extends BaseClass{
	
	IndexPage indexPage;
	SearchProductPage searchProductPage;
	ProductDetailPage productDetailPage;
	ViewCart viewcart;
	LoginPage loginpage;
	AddressPage addressPage;
	CheckOut checkout;
	PaymentPage paymentPage;
	orderSummaryPage ordersummaryPage;
	
	//@Parameters("browser")
	@BeforeMethod
	public void setup() {
		launchApp();
		}
	
	
//@AfterMethod
//public void tearDown()
//	{
//	getDriver().quit();
//	}
	
	@Test()
	public void endToEndTest() 
	{
		indexPage = new IndexPage();
		searchProductPage= indexPage.clickonProductMenu();
		searchProductPage= indexPage.SearchProduct("T-shirt");
		//Thread.sleep(2000);
		productDetailPage= searchProductPage.viewProduct();
		boolean result= productDetailPage.isProductAvailable();
		Assert.assertTrue(result);
		productDetailPage.enterQty("2");
		productDetailPage.addToCart();
		viewcart = productDetailPage.clickOnViewCart();
		checkout= viewcart.ClickOnProceed();
		loginpage= checkout.clickOnCheckout();
		
		viewcart= loginpage.UserLogin1(prop.getProperty("username"), prop.getProperty("password"));
		
		viewcart= indexPage.clickonViewCartMenu();
		addressPage= viewcart.ClickOnProceed1();
		paymentPage = addressPage.ClickOnPlaceOrder();
		ordersummaryPage= paymentPage.PaymentDetails();
		ordersummaryPage.msgDisplay();
		ordersummaryPage.InvoiceDownload();
		ordersummaryPage.Continue();
//		 viewcart= new ViewCart();
//		 
//		 // Call the method and get the returned object
//	        Object res = viewcart.ClickOnProceed();
//	        
//	        if (res instanceof AddressPage) {
//	            AddressPage addressPage = (AddressPage) res;
//	            Assert.assertNotNull(addressPage);
//	            System.out.println("Successfully navigated to AddressPage.");
//	            
//	            
//	        } else if (res instanceof LoginPage) {
//	            LoginPage loginPage = (LoginPage) res;
//	            Assert.assertNotNull(loginPage);
//	            System.out.println("Successfully navigated to LoginPage.");
//	            viewcart= loginpage.UserLogin1(prop.getProperty("username"), prop.getProperty("password"));
//	            viewcart= indexPage.clickonViewCartMenu();
//	            
//	            
//	        } else {
//	            Assert.fail("Unexpected page type returned.");
//	        }
	        
	       
		// isko hi sahi karna hai subh ko 
//		loginpage= viewcart.ClickOnProceed();
//		indexPage= loginpage.UserLogin1(prop.getProperty("username"), prop.getProperty("password"));
//		viewcart= indexPage.clickonViewCartMenu();
//		addressPage= viewcart.ClickOnProceed();
	}
}
