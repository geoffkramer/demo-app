package com.example.theapp.tests;

import com.example.theapp.basePage.BasePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AppTest extends BasePage {

    @Test
    void appIsLaunched() {
        Assertions.assertTrue(BasePage.getAppPage().isTheAppTitlePresent());
        String appTitle = BasePage.getAppPage().getTheAppTitleText();
        System.out.println("The app title is: " + appTitle);
    }

    @Test
    void navigateToPhotos() {
        // Assuming appPage is accessible (either through BasePage.getAppPage() or directly if BasePage is extended)
        BasePage.getAppPage().tapPhotosSection();

        // Assert that the photo title is present
        boolean isTitlePresent = BasePage.getAppPage().isThePhotoTitlePresent();
        Assertions.assertTrue(isTitlePresent, "Checking photo title is present after navigating to the Photos section.");

        if (isTitlePresent) {
            System.out.println("Test is working - Photo title is present.");
        } else {
            System.out.println("Test failed - Photo title is not present.");
        }
    }
}