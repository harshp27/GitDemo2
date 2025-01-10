package org.harshpathakacp.pageObjects.android;

import org.harshpathakacp.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {
	
AndroidDriver driver ;
	
	public ProductCatalogue(AndroidDriver driver) {         //constructor
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
	//driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]")
	private WebElement addtoCart1;
    
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]")
	private WebElement addtoCart2;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
	private WebElement cartButton;
	
	public void clickAddToCart() {
		
		addtoCart1.click();
		addtoCart2.click();
	}
	
	public CartPage clickcartButton() throws InterruptedException {
		
		cartButton.click();
		Thread.sleep(6000);
		return new CartPage(driver);
		
	}
}


