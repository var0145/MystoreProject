/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class ProductDetailPage extends BaseClass{
	
	@FindBy(xpath="//b[normalize-space()='Availability:']")
	WebElement productAvailable;

	@FindBy(xpath="//input[@id='quantity']")
	WebElement qty;
	
	//@FindBy(xpath="//button[@type='button']")
	@FindBy(xpath="//button[@class='btn btn-default cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//u[normalize-space()='View Cart']")
	WebElement viewcart;
	
	@FindBy(xpath="//p[normalize-space()='Your product has been added to cart.']")
	WebElement ValidatecartMsg;
	
	public  ProductDetailPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	public boolean isProductAvailable()
	{
		 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
	        try {
	            return wait.until(ExpectedConditions.visibilityOf(productAvailable)).isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Exception in isProductAvailable: " + e.getMessage());
	            return false;
	        }
	}
	
	public void enterQty(String quantity)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        try {
            WebElement qtyField = wait.until(ExpectedConditions.visibilityOf(qty));
            qtyField.clear();
            qtyField.sendKeys(quantity);
        } catch (Exception e) {
            System.out.println("Exception in enterQty: " + e.getMessage());
        }
	}
	
	public void addToCart()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
            addToCartButton.click();
        } 
        catch (Exception e) {
            System.out.println("Exception in addToCart: " + e.getMessage());
        }
	}
	
	public boolean validateAddToCart()
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        try {
            return wait.until(ExpectedConditions.visibilityOf(ValidatecartMsg)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception in validateAddToCart: " + e.getMessage());
            return false;
        }
	}
	
	public ViewCart clickOnViewCart()
	{
		 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
	        try {
	            WebElement viewCartElement = wait.until(ExpectedConditions.elementToBeClickable(viewcart));
	            //((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartElement);
	            // Alternatively, you can use:
	            viewCartElement.click();
	        } catch (Exception e) {
	            System.out.println("Exception in clickOnViewCart: " + e.getMessage());
	        }
	        return new ViewCart();
		
	}
}