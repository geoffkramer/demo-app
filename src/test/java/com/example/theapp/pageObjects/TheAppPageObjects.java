package com.example.theapp.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.example.theapp.basePage.BasePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TheAppPageObjects extends BasePage {
    
    private final AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TheApp']") 
    public WebElement theAppTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Photo Demo\")")
    public WebElement photoDemoText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Photo Library. Tap a photo!\")")
    public WebElement photosSectionTitle;

    /// Constructor that takes an AndroidDriver
    public TheAppPageObjects(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isTheAppTitlePresent() {
        return theAppTitle.isDisplayed();
    }

    // Method to get the text of the app title
    public String getTheAppTitleText() {
        return theAppTitle.getText();
    }

    public void tapPhotosSection() {
        photoDemoText.click();
    }

    public String getPhotosTitle() {
        return photosSectionTitle.getText();
    }

    public boolean isThePhotoTitlePresent() {
        return photosSectionTitle.isDisplayed();
    }



}
