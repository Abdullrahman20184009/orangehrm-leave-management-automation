package com.orangehrm.base;

import com.orangehrm.pages.CreateEmployeePage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.EntitlementsPage;
import com.orangehrm.pages.LeaveRequestPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected CreateEmployeePage createEmployeePage;
    protected EntitlementsPage entitlementsPage;
    protected LeaveRequestPage leaveRequestPage;

    @BeforeMethod
    public void setUp() {

        DriverManager.initDriver();

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        createEmployeePage = new CreateEmployeePage();
        entitlementsPage = new EntitlementsPage();
        leaveRequestPage = new LeaveRequestPage();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}