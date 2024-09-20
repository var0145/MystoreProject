/**
 * 
 */
package com.mystore.pageobjects;


import java.time.Duration;

import org.openqa.selenium.By;
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
public class SearchProductPage extends BaseClass
{
	
	@FindBy(xpath="(//a[contains(text(),'View Product')])[1]")
	WebElement productResult;
	//@FindBy(xpath="a[href='/product_details/28']")
	
	
	@FindBy(xpath="//input[@id='quantity']")
	WebElement qty;

	public SearchProductPage() 
	{
	
	PageFactory.initElements(getDriver(),this);
	
	}
//	public ProductDetailPage viewProduct()
//	{
////		productResult.click();
////		return new ProductDetailPage();
//		
//		// Optionally wait until the element is clickable
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//          wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//iframe[contains(@src, 'googleads')]")));
//          
//          
//		 if (productResult != null) 
//		 {
//			
//	            productResult.click();
//	            return new ProductDetailPage();
//	        } else {
//	            throw new NullPointerException("productResult WebElement is null");
//	        }
//		 
//	}
	
	
		public ProductDetailPage viewProduct() 
		{
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));

        // Wait for ad iframes to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//iframe[contains(@src, 'googleads')]")));

        // Retry mechanism for clicking the product
        int retries = 0;
        boolean clicked = false;
        while (retries < 3 && !clicked) {
            try {
                // Wait until the product link is clickable
                WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(productResult));
                
             // Scroll into view and click using JavaScript
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                
                js.executeScript("arguments[0].scrollIntoView(true);", clickableElement);
                js.executeScript("arguments[0].click();", clickableElement);
                
                clicked = true; // Break out of loop if click was successful
            } catch (Exception e) {
                // Log exception details (optional)
                System.out.println("Exception during click attempt: " + e.getMessage());
                retries++;
                // Optionally wait before retrying
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        
        if (!clicked) {
            throw new RuntimeException("Failed to click on the product after multiple attempts.");
        }

        return new ProductDetailPage();
    }
}
