package org.harshpathakacp.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.harshpathakacp.pageObjects.android.FormPage;
import org.harshpathakacp.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends AppiumUtils {
	
	protected AndroidDriver driver;

	public FormPage formPage;
	
    public BaseTest(AndroidDriver driver) {
        super(driver);
        // Initialization code for BaseTest
        System.out.println("BaseTest initialized with driver");
    }
	

	
	@BeforeClass(alwaysRun=true)
	public void CofigureAppium() throws URISyntaxException, IOException
	{
           Properties prop = new Properties();
           FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/harshpathakacp/resources/data.properties");
           String ipAddress = System.getProperty("ipAddress")!=null? System.getProperty("ipAddress") :  prop.getProperty("ipAddress");// this is used when we use maven command from command promt using -DipAddress
           prop.load(fis);
         //  String ipAddress = prop.getProperty("ipAddress");// this done for maven command
           String port = prop.getProperty("port");
		
		  service = startAppiumServer(ipAddress,Integer.parseInt(port));
	    

	    
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
	        options.setChromedriverExecutable("C:\\Users\\HP\\eclipse-workspace\\Appim\\driver\\chromedriver.exe");
	       // options.setApp("C:\\Users\\HP\\eclipse-workspace\\Appim\\src\\test\\ApiDemos-debug (4).apk");
	        options.setApp(System.getProperty("user.dir")+"//src//main//java//org//harshpathakacp//resources//resources//General-Store.apk");
	     
	        

	       

	       driver = new AndroidDriver(service.getUrl(), options);
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       formPage = new FormPage(driver);
}
	
	@AfterClass(alwaysRun=true)
	public void TearDown() {
        driver.quit();
        
    service.stop();
	}

	
	
}
