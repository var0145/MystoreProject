package com.mystore.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public static WebDriver driver;
	
	//Declare threadlocal driver
	public static ThreadLocal <RemoteWebDriver> driver= new ThreadLocal<>();
	
	public static Properties prop;
	
	@BeforeSuite
	public void loadconfig() {
	
			ExtentManager.setExtent();  //configure extent manager
			
			// create object of properties class 
			
			 prop = new Properties();
			
			//load the property file 
			
			try(FileReader file =new FileReader ("./configuration/Config.properties"))
			{
				prop.load(file);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	}
	
	public static WebDriver getDriver()
	{
		//Get driver from threadlocalmap
		return driver.get();
	}
	
	//launch app method
	public static void launchApp()
	{
			WebDriverManager.chromedriver().setup();
			
			String browsername = prop.getProperty("browser");
			
			if(browsername.contains("chrome"))
			{
				//driver= new ChromeDriver();
				
				//set browser to threadlocalmap
				driver.set(new ChromeDriver());
			}
			
			else if(browsername.contains("firefox"))
			{
				//driver= new FirefoxDriver();
				driver.set(new FirefoxDriver());
			}
			else if(browsername.contains("IE"))
			{
				//driver= new InternetExplorerDriver();
				driver.set(new InternetExplorerDriver());
			}
			getDriver().manage().window().maximize();
			getDriver().get(prop.getProperty("Url"));
			
			
	}
	
	// Ensure to quit WebDriver instances after test execution to free resources
    	public static void quitDriver() {
        WebDriver webDriver = getDriver();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove(); // Clean up thread-local reference
        }
    }
    	
    	public static void screenShot()
    	{
    		// Take screenshot
    		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		
    		// Define the destination
    		File destination = new File("D:\\Varsha\\YoutubeProject\\MyStore\\Screenshot\\screenshot.png");
    		
    		try {
    		    // Copy the screenshot to the specified location
    		    FileUtils.copyFile(screenshot, destination);
    		    System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
    		} catch (IOException e) {
    		    System.err.println("Failed to save screenshot: " + e.getMessage());
    		}
    	}
	
    @AfterSuite
	public void afterSuit() {
	
			ExtentManager.endReport();  //configure extent manager
	}
    
	}






