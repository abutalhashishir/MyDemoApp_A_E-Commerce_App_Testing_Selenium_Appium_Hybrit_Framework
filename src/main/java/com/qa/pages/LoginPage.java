package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

    @SuppressWarnings("rawtypes")
    public AndroidDriver driver;

   
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]")
    private WebElement loginBTN;
    
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    private WebElement loginSuccessHeading;
    
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView")
    private WebElement invalidError;
    
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Password-error-message\"]/android.widget.TextView")
    private WebElement EmptyPasswordError;
    
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Username-error-message\"]/android.widget.TextView")
    private WebElement EmptyAllFieldError;
    
    @SuppressWarnings("rawtypes")
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  
    
    public void loginWithMendatoryField(String validUserNameTEXT, String validPassword) {
    	userNameField.sendKeys(validUserNameTEXT);
    	passwordField.sendKeys(validPassword);
    	loginBTN.click();
    	
    	
    }
    public void loginWithEmptyField() {

    	loginBTN.click();
    }
    public void loginWithEmptyPasswordField(String validUserNameText) {
    	userNameField.sendKeys(validUserNameText);
    	passwordField.sendKeys("");
    	loginBTN.click();
    }
    
    public String retrieveLoginSuccessPageHeading() {
		
		String loginSuccessHeadingText = loginSuccessHeading.getText();
		return loginSuccessHeadingText;
	}
    
    public String invalidCredintialsError() {
    	String invalidCredintialsErrorText = invalidError.getText();
		return invalidCredintialsErrorText;
    }
    public String emptyPasswordError() {
    	String emptyStringPasswordErrorText = EmptyPasswordError.getText();
		return emptyStringPasswordErrorText;
    }
    public String emptyAllFieldError() {
    	String EmptyAllFieldErrorText = EmptyAllFieldError.getText();
		return EmptyAllFieldErrorText;
    }
    
}