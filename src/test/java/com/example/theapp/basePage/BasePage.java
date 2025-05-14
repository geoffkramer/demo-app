package com.example.theapp.basePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.theapp.pageObjects.TheAppPageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BasePage {

    protected static AndroidDriver driver;
    protected static WebDriverWait wait;
    protected static TheAppPageObjects appPage; // Made static
    private static final String appPath = "path"
    private static final String APPIUM_URL = "http://localhost:4723";

    @BeforeAll
    static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 9");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability("newCommandTimeout", 300);

        URL appiumServerURL = new URL(APPIUM_URL);
        driver = new AndroidDriver(appiumServerURL, capabilities);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        appPage = new TheAppPageObjects(driver);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to get the driver instance for Page Objects and tests
    public static AndroidDriver getDriver() {
        return driver;
    }

    // Method to get the WebDriverWait instance if needed
    public static WebDriverWait getWait() {
        return wait;
    }

    public static TheAppPageObjects getAppPage() { 
        return appPage;
    }
}