package org.harshpathakacp;

import org.harshpathakacp.TestUtils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class eCommerce_tc_1 extends BaseTest {
	



		// TODO Auto-generated constructor stub
	  public eCommerce_tc_1() {
	        super(null);  // TestNG will initialize the driver through @BeforeClass in BaseTest
	    }

	


	@BeforeMethod
	public void preSetup() {
		
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity" );
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity")
                );
	}
	
	
	@Test
	public void FillForm_ErrorValidation() {
		
		//driver.findElement(By.className("android.widget.EditText")).sendKeys("Harsh Pathak");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.wigit.toast)[1]")).getAttribute("name"); //Verifying toast message 
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
	}
	
	@Test
public void FillForm_PositiveFlow() {
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Harsh Pathak");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.wigit.toast)[1]")).size()<1); //Verifying toast message 
	

	}}
