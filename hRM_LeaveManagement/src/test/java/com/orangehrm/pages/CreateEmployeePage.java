package com.orangehrm.pages;

import com.orangehrm.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page object for the Add Employee screen under the PIM module
public class CreateEmployeePage {

    private static final String ADD_EMPLOYEE_URL =
            "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";

    // Locators
    private final By firstNameField = By.name("firstName");
    private final By lastNameField = By.name("lastName");
    private final By toggleSwitch = By.xpath("//span[contains(@class,'oxd-switch-input')]");
    private final By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By passwordField = By.xpath("(//input[@type='password'])[1]");
    private final By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    private final By saveButton = By.xpath("//button[@type='submit']");

    // Open the Add Employee page
    public void navigateTo() {
        DriverManager.getDriver().get(ADD_EMPLOYEE_URL);

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );

        System.out.println("Add Employee page loaded");
    }

    // Create a new employee with login credentials
    public void createEmployee(String firstName,
                               String lastName,
                               String username,
                               String password) {

        DriverManager.getDriver().findElement(firstNameField).sendKeys(firstName);
        DriverManager.getDriver().findElement(lastNameField).sendKeys(lastName);

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(toggleSwitch)
        ).click();

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );

        DriverManager.getDriver().findElement(usernameField).sendKeys(username);
        DriverManager.getDriver().findElement(passwordField).sendKeys(password);
        DriverManager.getDriver().findElement(confirmPasswordField).sendKeys(password);

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(saveButton)
        ).click();

        DriverManager.getWait().until(
                ExpectedConditions.urlContains("viewPersonalDetails")
        );

        System.out.println("Employee created: " + firstName + " " + lastName);
        System.out.println("Login username: " + username);
    }
}