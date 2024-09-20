package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.*;

public class IndexPage extends BaseClass{

		@FindBy(xpath="//i[@class='fa fa-lock']")
		WebElement signInBtn; 
		
		
		@FindBy(xpath="//img[@src='/static/images/home/logo.png']")
		WebElement Logo;
		
		@FindBy (xpath="//input[@id=\"search_product\"]")
		WebElement searchProductBox;
		
		
		
		@FindBy (xpath="//button[@id=\"submit_search\"]")
		WebElement submitSearch;
		
		@FindBy(xpath="//i[@class=\"material-icons card_travel\"]")
		WebElement productMenu;
		
		@FindBy(xpath="//i[@class=\"fa fa-shopping-cart\"]")
		WebElement viewCart;
		
		public IndexPage() 
		{
			
				PageFactory.initElements(getDriver(),this);	
		
		}
		
		public LoginPage singIn()
		{
			signInBtn.click();
			return new LoginPage();
		}
		
		public SearchProductPage clickonProductMenu()
		{
			productMenu.click();
			return new SearchProductPage();
		}
		
		public ViewCart clickonViewCartMenu()
		{
			viewCart.click();
			return new ViewCart();
		}
		
		public boolean validateLogo()
		{
			return Logo.isDisplayed();
		}
		
		public String getTitle()
		{
			String StoreTitle= getDriver().getTitle();
			System.out.println(StoreTitle);
			return StoreTitle;
			
		}
		
		public String getCurrUrl()
		{
			String pageUrl= getDriver().getCurrentUrl();
			return pageUrl;
		}
		public SearchProductPage SearchProduct(String productName)
		{
			searchProductBox.sendKeys(productName);
			submitSearch.click();
			return new SearchProductPage();
			
		}
		
	}
		
		
		

