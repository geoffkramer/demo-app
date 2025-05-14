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
}