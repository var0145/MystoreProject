/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class ViewCart extends BaseClass{

		@FindBy(xpath="//a[normalize-space()='Proceed To Checkout']")
		// //a[@class='btn btn-default check_out']
		WebElement ProceedtoCheckout;
		
		@FindBy(xpath="//li[@class='active']")
		WebElement text;
		
		@FindBy(xpath="//li[@class='active']")
		WebElement qty;
		
		@FindBy(xpath="//td[@class='cart_price']/p")
		WebElement unitPrice;
		
		@FindBy(xpath="//td[@class='cart_total']/p")
		WebElement totalPrice;
		
		public ViewCart()
		
		{
			PageFactory.initElements(getDriver(), this);
		}
		
		public double getUnitPrice() 
		{
			String UPrice = unitPrice.getText();
			String unit= UPrice.replaceAll("[^0-9.]", "");
			try
			{ 
				 // Parse the cleaned numeric string to a double
				double finalUnitPrice= Double.parseDouble(unit);
				// Return the value in the expected unit (e.g., dollars, or divide by 100 if needed)
		        return finalUnitPrice / 100; // Adjust this line as needed based on your requirement
		    } catch (NumberFormatException e) {
		        // Handle the case where parsing fails
		        System.err.println("Failed to parse the unit price: " + e.getMessage());
		        return 0.0; // Or handle the error as appropriate
		    }
		}
		
		
		public double getTotalPrice() 
		{
			String TPrice = totalPrice.getText();
			String tot= TPrice.replaceAll("[^0-9.]", "");
			try {
		        // Parse the cleaned numeric string to a double
			double finalTotalPrice= Double.parseDouble(tot);
			// Return the value in the expected unit (e.g., dollars, or divide by 100 if needed)
			 return finalTotalPrice / 100;// Adjust this line as needed based on your requirement
		    } 
			catch (NumberFormatException e) {
		        // Handle the case where parsing fails
		        System.err.println("Failed to parse the total price: " + e.getMessage());
		        return 0.0; // Or handle the error as appropriate
		    }
		}
		
		
		public CheckOut ClickOnProceed() 
		{
			WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(60));
	        try{
	        	WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(ProceedtoCheckout));
	        
	       
	        proceedButton.click();
			
		}
	        catch(TimeoutException e) {
	            System.err.println("Timed out waiting for the 'Proceed To Checkout' button to be clickable: " + e.getMessage());
	            // Optionally, capture a screenshot or perform additional error handling here
	        }
	        return new CheckOut();
		}
		public AddressPage ClickOnProceed1() 
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
	        WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(ProceedtoCheckout));
	       
	        proceedButton.click();
			return new AddressPage();
		}
		

}
