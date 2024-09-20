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
public class LoginPage extends BaseClass {
	
	@FindBy(name="name")
	WebElement userName;
	
	//@FindBy(name="email")
	@FindBy(xpath="//input[@data-qa=\"signup-email\"]")
	WebElement newUserMail;
	
	@FindBy(xpath="//button[@data-qa=\"signup-button\"]")
	WebElement signUpBtn;
	
	//@FindBy(name="email")
	@FindBy(xpath="//input[@data-qa=\"login-email\"]")
	WebElement emailAddress;
	
	@FindBy(name="password")
	WebElement pswd;
	
	@FindBy(xpath="//button[@data-qa=\"login-button\"]")
	WebElement loginBtn;
	
	public LoginPage() 
	{
		
		PageFactory.initElements(getDriver(),this);	
	
	}
	
	public IndexPage UserLogin(String useremail, String Password)
	{
		
		emailAddress.sendKeys(useremail);
		pswd.sendKeys(Password);
		loginBtn.click();
		return new IndexPage();
	}
	
	
	public ViewCart UserLogin1(String useremail, String Password)
	{
		
		emailAddress.sendKeys(useremail);
		pswd.sendKeys(Password);
		loginBtn.click();
		return new ViewCart();
		
	}
	
	public AccountCreationPage createNewAccount(String uname, String email) 
	{
		userName.sendKeys(uname);
		newUserMail.sendKeys(email);
		signUpBtn.click();
		return new AccountCreationPage();
	}
}
