package org.harshpathakacp.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{

	
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		 
		super(driver);
		this.driver = driver;
	}
	public void LongPressAction(WebElement ele) {
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
	}

	public void ScrollToEndAction() {
		  boolean canScrollMore;
		    do {
		        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		        	    "left", 100, "top", 100, "width", 200, "height", 200,
		        	    "direction", "down",
		        	    "percent", 3.0
		        	));
		        }
		        		while(canScrollMore) ;
	}
	
	public void scrollToText(String text) {
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	public void swipeAction(WebElement ele , String Direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", 2000,
                "direction", "left",
                "percent", 0.75));
	}
	
	
	
}
