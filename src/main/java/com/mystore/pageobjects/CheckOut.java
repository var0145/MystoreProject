/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class CheckOut extends BaseClass{
	
	@FindBy(xpath="(//p[@class='text-center'])[2]")
	WebElement checkout;
	
	public CheckOut()
	
	{
		PageFactory.initElements(getDriver(), this);
	}
	public LoginPage clickOnCheckout()
	{
		checkout.click();
		return new LoginPage();
	}

}
