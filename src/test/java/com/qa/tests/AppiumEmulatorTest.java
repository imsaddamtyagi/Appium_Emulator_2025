package com.qa.tests;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AppiumEmulatorTest
{
    AppiumDriver driver;
 	String apkPath = System.getProperty("user.dir") + "\\TestApk\\app-debug.apk"; 
	String GitLink =   "new UiSelector().description(\"Visit My GitHub Profile\")";



    @BeforeTest
    public void AppiumSetUp() throws URISyntaxException, MalformedURLException 
    {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setApp(apkPath); 
        options.setNoReset(true);       
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setDeviceName("Android Emulator");
        options.setAutomationName("UiAutomator2");

        
        URI uri = new URI("http://127.0.0.1:4723");
        System.out.println("Launching Application now...");  
        
        long startTime = System.currentTimeMillis();
        driver = new AndroidDriver(uri.toURL(), options);
        long endTime = System.currentTimeMillis();
        double executionTimeInSeconds = (endTime - startTime) / 1000.0; // Divide by 1000 for seconds
        
        System.out.println("Time taken in launching application: " + executionTimeInSeconds + " seconds");
    }


    
    @Test
    public void MyFirstTest_Appium() throws InterruptedException
    {
   	 
    Thread.sleep(10000);
   	 doClick(driver,GitLink);
      
   
   	 }
    
    
    
    
    
    public static   void doClick(AppiumDriver driver, String locator)
    { 
   	 
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
   elem.click();

   
    }
    
    
    public static   void doSend(AppiumDriver driver, String locator,String value)
    { 
   	 
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
   elem.sendKeys(value);

   
    }
    
    
}
