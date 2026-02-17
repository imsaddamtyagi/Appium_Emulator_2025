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
    
 	String apkPath     =   System.getProperty("user.dir") + "\\TestApk\\Demo.apk"; 
 	
	String GitLink     =   "new UiSelector().resourceId(\"com.bitbar.testdroid:id/editText1\")";
	String Answer      =   "new UiSelector().resourceId(\"com.bitbar.testdroid:id/button1\")";
	String AnswerXpath =   "//android.widget.Button[@resource-id=\"com.bitbar.testdroid:id/button1\"]";

	AppiumDriver driver;

    @BeforeTest
    public void AppiumSetUp() throws URISyntaxException, MalformedURLException 
    {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setApp(apkPath);      
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");
        options.setNoReset(true);  

         
        URI uri = new URI("http://127.0.0.1:4723");
        System.out.println("Launching Application now...");  
        
        long startTime = System.currentTimeMillis();
        driver = new AndroidDriver(uri.toURL(), options);
        long endTime = System.currentTimeMillis();
        double executionTimeInSeconds = (endTime - startTime) / 1000; // Divide by 1000 for seconds
        
        System.out.println("Time taken in launching application: " + executionTimeInSeconds + " seconds");
    }

    
    @Test
    public void MyFirstTest_Appium() throws InterruptedException
    { 	 
    Thread.sleep(10000);
    doSend(driver,GitLink,"Nokia");
    doClickXpath(driver,AnswerXpath);    
   	 }
    
     
    public static void doClick(AppiumDriver driver, String locator)
    {  	 
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
   elem.click();
   System.out.println("Clicked Success");   
    }
    
    
    public static void doSend(AppiumDriver driver, String locator,String value)
    { 
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
   elem.sendKeys(value);
   System.out.println("Send Success:"+value);     
    }
    
    
    public static void doClickXpath(AppiumDriver driver, String locator)
    {  	 
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(locator))); 
   elem.click();
   System.out.println("Clicked Success using xpath");   
    }
    
    
    
}
