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
public class orderSummaryPage extends BaseClass {

	@FindBy(xpath="//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
	WebElement confirmOrder;
	
	
	@FindBy(xpath="//a[@class=\"btn btn-default check_out\"]")
	WebElement downloadInv;
	
	@FindBy(xpath="//a[@class=\"btn btn-primary\"]")
	WebElement Continue;
	
	public orderSummaryPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean msgDisplay()
	{
		System.out.println("confirm order page displayed");
		return confirmOrder.isDisplayed();
		
	}
	
	public void InvoiceDownload()
	{
		downloadInv.click();
	}
	
	public IndexPage Continue()
	{
		Continue.click();
		return new IndexPage();
		
	}
}
