package com.qa.Listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.qa.base.Base;
import io.appium.java_client.android.AndroidDriver;



public class MyListeners extends Base implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase Case Execution Started :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("Testcase Passed :"+result.getName());
		
	}


	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("Testcase Failed :"+result.getName());
		  String testMethodName = result.getMethod().getMethodName();
		  AndroidDriver mobileDriver = null;		  
		  try {
			  mobileDriver =(AndroidDriver)result.getTestClass().getRealClass().getDeclaredField("mobileDriver").get(result.getInstance());
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		  
		  try {
			takeScreenShotPath(testMethodName, mobileDriver);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase Case Execution Skipped :"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
