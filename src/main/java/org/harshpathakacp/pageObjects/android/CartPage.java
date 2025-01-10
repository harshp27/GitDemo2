package org.harshpathakacp.pageObjects.android;

import java.util.List;

import org.harshpathakacp.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {

	
	AndroidDriver driver ;
	
	public CartPage(AndroidDriver driver) {         //constructor
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//	List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
//	int count= productPrices.size();
	//double totalSum =0;
	//for(int i=0;i<count;i++) {
		//String amountString = productPrices.get(i).getText();
		//Double price =getFormattedAmount(amountString);
		//totalSum = totalSum + price;
	//}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	//String displaySum=	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	//Double displayFormattedSum = getFormattedAmount(displaySum);
//	Assert.assertEquals(totalSum, displayFormattedSum);
		
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	//WebElement termsCondition=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/termsButton']"));
//	LongPressAction(termsCondition);
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/termsButton']")
	public WebElement terms;
	
	//driver.findElement(By.className("android.widget.Button")).click();
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement acceptButton ;
	
	//driver.findElement(By.className("android.widget.CheckBox")).click();
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox ;
	
	//driver.findElement(By.className("android.widget.Button")).click();
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement proceed ;
	
	public List<WebElement>getproductList(){
		return productList;
		
	}
	
	public double getProductsSum() {
		
		
		int count= productList.size();
		double totalSum =0;
		for(int i=0;i<count;i++) {
			String amountString = productList.get(i).getText();
			Double price =getFormattedAmount(amountString);
			totalSum = totalSum + price;
	
		
		
	}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
		
		
	}
	
	public void acceptTermsConditions() {
		
		LongPressAction(terms);
		acceptButton.click();
		
		
	}
	
	public void submitOrder() {
		
		checkBox.click();
		proceed.click();
	}
	
	
	
	
}
