package com.orangehrm.pages;

import com.orangehrm.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

// Page object for the Apply Leave screen
public class LeaveRequestPage {

    private static final String LEAVE_URL =
            "https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave";

    // Locators
    private final By leaveForm = By.cssSelector(".oxd-form");
    private final By leaveTypeDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private final By commentField = By.xpath("//textarea");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By fromDateField = By.xpath("(//div[contains(@class,'oxd-date-input')]//input)[1]");
    private final By successToast = By.xpath(
            "//*[contains(@class,'oxd-toast--success') or contains(@class,'oxd-toast-content')]"
    );

    // Navigate to the Apply Leave page
    public void navigateTo() {
        DriverManager.getDriver().get(LEAVE_URL);

        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(leaveForm)
        );

        System.out.println("Apply Leave page loaded");
    }

    // Select leave type
    public void selectLeaveType(String leaveType) {

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(leaveTypeDropdown)
        ).click();

        By leaveOption = By.xpath(
                "//div[@role='option']//span[contains(text(),'" + leaveType + "')]"
        );

        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(leaveOption)
        ).click();

        System.out.println("Leave type selected: " + leaveType);
    }

    // Enter the start date
    public void setFromDate(String date) {

        WebElement fromDate = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(fromDateField)
        );

        fromDate.clear();
        fromDate.sendKeys(date);

        System.out.println("From date set: " + date);
    }

    // Enter leave comment
    public void addComment(String comment) {

        WebElement commentBox = DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(commentField)
        );
        commentBox.clear();
        commentBox.sendKeys(comment);
        System.out.println("Comment entered");
    }

    // Submit leave request
    public void submit() {
        DriverManager.getWait().until(
                ExpectedConditions.elementToBeClickable(submitButton)
        ).click();
        System.out.println("Leave request submitted");
    }

    // Verify successful submission
    public void verifySuccess() {

        WebElement toast = DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(successToast)
        );

        Assert.assertTrue(
                toast.isDisplayed(),
                "Success toast not displayed. Leave request may have failed."
        );

        System.out.println("Leave request submitted successfully");
    }
}