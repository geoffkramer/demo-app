package com.example.theapp.basePage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

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
    protected static TheAppPageObjects appPage;
    private static String platformName;
    private static String deviceName;
    private static String appPath;
    private static String automationName;
    private static final String APPIUM_URL = "http://localhost:4723";

    @BeforeAll
    static void setUp() throws MalformedURLException {
        loadConfig();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        capabilities.setCapability("newCommandTimeout", 300);

        URL appiumServerURL = new URL(APPIUM_URL);
        driver = new AndroidDriver(appiumServerURL, capabilities);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        appPage = new TheAppPageObjects(driver);
    }

    private static void loadConfig() {
        Properties prop = new Properties();
        try (InputStream input = BasePage.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            String[] propertyValues = {
                    prop.getProperty("platformName"),
                    prop.getProperty("deviceName"),
                    prop.getProperty("automationName"),
                    prop.getProperty("pathToApp")
            };

            platformName = propertyValues[0];
            deviceName = propertyValues[1];
            automationName = propertyValues[2];
            appPath = propertyValues[3];

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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