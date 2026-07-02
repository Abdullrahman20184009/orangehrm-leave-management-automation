package com.orangehrm.pages;

import com.orangehrm.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page object for OrangeHRM Login page
public class LoginPage {

    private static final String BASE_URL =
            "https://opensource-demo.orangehrmlive.com/";

    // Locators
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    private final By userMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");

    // Open the login page
    public void navigateTo() {
        DriverManager.getDriver().get(BASE_URL);

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );

        System.out.println("Login page loaded");
    }

    // Login using valid credentials
    public void login(String username, String password) {

        DriverManager.getDriver().findElement(usernameField).sendKeys(username);
        DriverManager.getDriver().findElement(passwordField).sendKeys(password);

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();

        System.out.println("Logged in as: " + username);
    }

    // Logout from the application
    public void logout() {

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(userMenu)
        ).click();

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(logoutButton)
        );

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(logoutButton)
        ).click();

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );

        System.out.println("Logged out successfully");
    }
}