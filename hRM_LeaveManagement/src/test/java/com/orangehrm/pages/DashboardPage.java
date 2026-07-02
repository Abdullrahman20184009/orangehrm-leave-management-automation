package com.orangehrm.pages;

import com.orangehrm.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardPage {

    private final By dashboardWidget =
            By.xpath("//div[contains(@class,'oxd-grid-item')]");

    public void verifyLoaded() {
        DriverManager.getWait().until(
                ExpectedConditions.urlContains("dashboard"));
        DriverManager.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(dashboardWidget));
        Assert.assertTrue(
                DriverManager.getDriver().getCurrentUrl().contains("dashboard"),
                "Dashboard not loaded after login");
        System.out.println("Dashboard loaded successfully");
    }
}