package org.harshpathakacp.pageObjects.android;

import org.harshpathakacp.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends AndroidActions {

	AndroidDriver driver ;
	
	public FormPage(AndroidDriver driver) {         //constructor
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	//driver.findElement(By.className("android.widget.EditText")).sendKeys("Harsh Pathak");
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	//driver.findElement(By.className("android.widget.Spinner")).click();
	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	//driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	
	@AndroidFindBy(className="android.widget.Spinner")
	private WebElement countrySelection;
	
	//driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")
	private WebElement LetsShopButton;
	
	public void setNameField(String name) {         // Action method
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void setcountrySelection(String countryName) {
		
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	public void setActivity() {
		
		
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity" );
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity")
                );
		
	}
	public ProductCatalogue setletsshopButton() {
		
		LetsShopButton.click();
		return new ProductCatalogue(driver);
	}
}
