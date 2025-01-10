package org.harshpathakacp.TestUtils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.harshpathakacp.utils.AppiumUtils;
import org.testng.ITestContext;

public class Listeners extends AppiumUtils implements ITestListener {
	
	AppiumDriver driver;
	
	public Listeners(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
    
    @Override
    public void onTestStart(ITestResult result) {
    	 test=extent.createTest(result.getMethod().getMethodName());  //whenever we first run this test object of extent main class get automatically created we can name it test we can use it for further congig
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
       test.fail(result.getThrowable());
       try {
       driver= (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
       }catch(Exception e1) {
    	   
    	   e1.printStackTrace();
       }
       
       try {
    	    test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
    	} catch (IOException e) {
    	    e.printStackTrace();}
    	}


    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is not commonly used
    }

    @Override
    public void onStart(ITestContext context) {
        // This method can be used to perform some setup before any test method is run
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
