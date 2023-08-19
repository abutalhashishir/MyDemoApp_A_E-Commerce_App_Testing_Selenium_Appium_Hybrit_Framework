package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest  extends Base{
	
	@SuppressWarnings("rawtypes")
	public AndroidDriver driver;
	
	
	
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initialize() throws InterruptedException {
		driver = initializeDriver();
		HomePage homePage = new HomePage(driver);
		homePage.loginFunctionality();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginWithValidCredintials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginWithMendatoryField(dataProp.getProperty("validUserName"), dataProp.getProperty("validPassword"));
		
		Assert.assertEquals(loginPage.retrieveLoginSuccessPageHeading(),dataProp.getProperty("logInSuccessHeading"),"Login Success page is not displayed");
		
	}
	
	@Test(priority = 2)
	public void loginWithInvalidCredintials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginWithMendatoryField(dataProp.getProperty("validUserName"), dataProp.getProperty("invalidPassword"));
		
		Assert.assertEquals(loginPage.invalidCredintialsError(),dataProp.getProperty("invalidCredintialsErrorHeading"),"invalidCredintialsErrorHeading text is not displayed");
		
	}
	@Test(priority = 3)
	public void loginWithEmptyPasswordField() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginWithEmptyPasswordField(dataProp.getProperty("validUserName"));
		
		
		Assert.assertEquals(loginPage.emptyPasswordError(),dataProp.getProperty("emptyPasswordErrorHeading")," Empty Password is not displayed");
		
	}
	@Test(priority = 4)
	public void loginWithEmptyField() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginWithEmptyField();
		Assert.assertEquals(loginPage.emptyAllFieldError(),dataProp.getProperty("emptyAllFieldErrorHeading")," Empty UserName is not displayed");
		
	}
	
	

}