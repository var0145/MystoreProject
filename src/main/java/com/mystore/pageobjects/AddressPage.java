/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class AddressPage extends BaseClass{
	
	private WebDriverWait wait;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement PlaceOrder;
	
	public AddressPage()
	{
		this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentPage ClickOnPlaceOrder()
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//	    wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder)).click();
		
		try {
            // Wait until the element is clickable
            WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
            // Scroll into view
            JavascriptExecutor js =  (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
            // Click the element
            PlaceOrder.click();
        }
		catch (ElementClickInterceptedException e) {
            System.err.println("Element click intercepted: " + e.getMessage());
            // Additional handling logic if needed
        }
		
		//PlaceOrder.click();
		return new PaymentPage();
	}

}
