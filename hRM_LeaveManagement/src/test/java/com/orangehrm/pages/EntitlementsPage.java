package com.orangehrm.pages;

import com.orangehrm.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page object for assigning leave entitlements to employees
public class EntitlementsPage {

    private static final String ENTITLEMENTS_URL =
            "https://opensource-demo.orangehrmlive.com/web/index.php/leave/addLeaveEntitlement";

    // Locators
    private final By leaveTypeDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private final By employeeField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By entitlementField = By.xpath("//label[contains(text(),'Entitlement')]/following::input[@class='oxd-input oxd-input--active'][1]");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By confirmButton = By.xpath("//button[normalize-space()='Confirm']");
    private final By successToast = By.xpath("//*[contains(@class,'oxd-toast--success')]");

    // Navigate to Add Leave Entitlement page
    public void navigateTo() {
        DriverManager.getDriver().get(ENTITLEMENTS_URL);

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(leaveTypeDropdown));

        System.out.println("Add Leave Entitlement page loaded");
    }

    // Assign leave entitlement to an employee
    public void addEntitlement(String firstName, String lastName, String leaveType, String days)
    {
        // Select leave type
        WebElement dropdown = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(leaveTypeDropdown));
        dropdown.click();

        WebElement leaveOption = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='option']//span[contains(text(),'" + leaveType + "')]")));
        leaveOption.click();

        System.out.println("Leave type selected: " + leaveType);

        // Search employee
        WebElement employeeInput = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(employeeField));

        employeeInput.clear();
        employeeInput.sendKeys(lastName);

        // Wait until autocomplete result appears
        WebElement employeeOption = DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='option']//span[contains(text(),'" + lastName + "')]")));

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(employeeOption));

        employeeOption.click();

        System.out.println("Employee selected: " + firstName + " " + lastName);

        // Enter entitlement days
        WebElement daysInput = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(entitlementField));

        daysInput.clear();
        daysInput.sendKeys(days);

        System.out.println("Entitlement entered: " + days + " day(s)");

        // Save
        DriverManager.getDriver().findElement(saveButton).click();

        // Wait until confirmation dialog appears
        WebElement confirm = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(confirmButton));

        confirm.click();

        // Wait until success toast appears
        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(successToast));

        System.out.println("Leave entitlement added successfully.");
    }
}