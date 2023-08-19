package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

    public AndroidDriver<MobileElement> driver;
    public String appiumServer = "127.0.0.1";
    public int appiumPort = 4723;
    URL appiumURL = null;
    public Properties prop;
    public Properties dataProp;

    public Base() {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties");

        dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\TestData\\OR.properties");

        try {
            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public AndroidDriver<MobileElement> initializeDriver() {
        try {
            appiumURL = new URL("http://" + appiumServer + ":" + appiumPort + "/wd/hub");
            this.driver = new AndroidDriver<MobileElement>(appiumURL, setAppCapabilitiesAndroid());
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public DesiredCapabilities setAppCapabilitiesAndroid() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MyPhone");

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

        cap.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        cap.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");	

        return cap;
    }
    
    public String takeScreenShotPath(String testCaseName,AndroidDriver mobileDriver) throws IOException{
    	
		TakesScreenshot ts=(TakesScreenshot) mobileDriver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/screenshorts/"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}



   
}
