package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	 
		@SuppressWarnings("rawtypes")
	    public AndroidDriver driver;

	    @FindBy(className = "android.widget.ImageView")
	    private WebElement menuBtn;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='menu item log in']")
	    private WebElement LoginMenu;
	    
	    @SuppressWarnings("rawtypes")
	    public HomePage(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void loginFunctionality() {
	        menuBtn.click();
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.elementToBeClickable(LoginMenu)).click();
	      
	    }
}