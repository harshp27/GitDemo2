package org.harshpathakacp.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	protected AppiumDriver driver;
    public AppiumDriverLocalService service;

    public AppiumUtils(AndroidDriver driver) {
        this.driver = driver;
        // Initialization code for AppiumUtils
        System.out.println("AppiumUtils initialized with driver");
    }

	
public Double getFormattedAmount(String amount) {
		
		Double price =Double.parseDouble(amount.substring(1));
		return price;
	}

public void waitelementToAppear(WebElement ele) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.attributeContains((ele), "text" ,"Cart"));
}

public AppiumDriverLocalService startAppiumServer(String ipAddress,int port) {
	
	  service = new AppiumServiceBuilder()
	            .withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	            .withIPAddress(ipAddress)
	            .usingPort(port)
	           .build();
	        service.start();
			return service;
			
}

public String getScreenshotPath(String testCaseName ,AppiumDriver driver) throws IOException {
	
	File source=driver.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	Files.copy(source,new File(destinationFile));
	return destinationFile;
	
	//1. Capture and Place in folder 2. extent report picks file and attach to report
}}
