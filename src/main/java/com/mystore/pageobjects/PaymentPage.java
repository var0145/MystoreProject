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
public class PaymentPage extends BaseClass{

	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement NameOnCard;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement CardNumber;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	WebElement Expirymm;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	WebElement Expiryyear;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement PayAndConfirm;
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public orderSummaryPage PaymentDetails()
	{
		
		NameOnCard.sendKeys("varsha");
		CardNumber.sendKeys("12345");
		cvc.sendKeys("123");
		Expirymm.sendKeys("05");
		Expiryyear.sendKeys("2026");
		PayAndConfirm.click();
		return new orderSummaryPage();
		
	}

}

