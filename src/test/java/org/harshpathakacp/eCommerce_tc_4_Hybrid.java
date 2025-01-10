package org.harshpathakacp;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.harshpathakacp.TestUtils.BaseTest;
import org.harshpathakacp.pageObjects.android.CartPage;
import org.harshpathakacp.pageObjects.android.FormPage;
import org.harshpathakacp.pageObjects.android.ProductCatalogue;
import org.harshpathakacp.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest{
	
	
	 public eCommerce_tc_4_Hybrid(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}





	@BeforeMethod(alwaysRun=true)
		public void preSetup() {
			
		 formPage = new FormPage(driver);
		formPage.setActivity();	
		
		}
		




	@Test(dataProvider="getData",groups= {"Smoke"})
	public void FillForm(String name,String gender,String country) throws InterruptedException {
		
		
		//FormPage formPage = new FormPage(driver);
		formPage.setNameField(name);     // this is for action method
		formPage.setGender(gender);
		formPage.setcountrySelection(country);

		ProductCatalogue productCatalogue = formPage.setletsshopButton(); // method for skipping object creation
		
	//	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.clickAddToCart();
		
		
		CartPage cartPage = productCatalogue.clickcartButton(); // method for skipping object creation
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text" ,"Cart"));
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		
		

	
		
		
		}
	
	
	
	
	
		
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][] { {"Harsh Pathak","female","Argentina"},{"Anil Pathak","male","Argentina"} };
	}}
	


	



