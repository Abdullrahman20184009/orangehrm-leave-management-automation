package com.orangehrm.tests;

import com.orangehrm.pages.*;
import com.orangehrm.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveRequestTest extends com.orangehrm.base.BaseTest {

    // Admin Credentials
    private static final String ADMIN_USERNAME = "Admin";
    private static final String ADMIN_PASSWORD = "admin123";

    // Dynamic Employee Data
    private static final String TIMESTAMP  = String.valueOf(System.currentTimeMillis()).substring(7);
    private static final String FIRST_NAME = "Test";
    private static final String LAST_NAME  = "User" + TIMESTAMP;
    private static final String USERNAME   = "testuser" + TIMESTAMP;
    private static final String PASSWORD   = "Test@1234";

    // Leave Config
    private static final String LEAVE_TYPE = "CAN - Vacation";
    private static final String DAYS       = "5";
    private static final String FROM_DATE  = "2026-08-01";
    private static final String COMMENT    = "Automated leave request via Selenium";
//
    //

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateEmployeePage createEmployeePage;
    EntitlementsPage entitlementsPage;
    LeaveRequestPage leaveRequestPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        loginPage          = new LoginPage();
        dashboardPage      = new DashboardPage();
        createEmployeePage = new CreateEmployeePage();
        entitlementsPage   = new EntitlementsPage();
        leaveRequestPage   = new LeaveRequestPage();
    }

    @Test
    public void testEmployeeSubmitLeaveRequest() throws InterruptedException {

        // PHASE 1: Admin Login
        System.out.println("PHASE 1: Admin Login");
        loginPage.navigateTo();
        loginPage.login(ADMIN_USERNAME, ADMIN_PASSWORD);
        dashboardPage.verifyLoaded();

        // PHASE 2: Create Employee
        System.out.println(" PHASE 2: Create Employee");
        createEmployeePage.navigateTo();
        createEmployeePage.createEmployee(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD);

        //PHASE 3: Add Leave Entitlement
        System.out.println("PHASE 3: Add Leave Entitlement");
        entitlementsPage.navigateTo();
        entitlementsPage.addEntitlement(FIRST_NAME, LAST_NAME, LEAVE_TYPE, DAYS);
        //PHASE 4: Logout
        System.out.println("PHASE 4: Logout");
        loginPage.logout();

        // PHASE 5: Employee Login
        System.out.println("PHASE 5: Employee Login ");
        loginPage.navigateTo();
        loginPage.login(USERNAME, PASSWORD);
        dashboardPage.verifyLoaded();

        // PHASE 6: Apply Leave
        System.out.println("PHASE 6: Apply Leave ");
        leaveRequestPage.navigateTo();
        leaveRequestPage.selectLeaveType(LEAVE_TYPE);
        leaveRequestPage.setFromDate(FROM_DATE);
        leaveRequestPage.addComment(COMMENT);
        leaveRequestPage.submit();
        leaveRequestPage.verifySuccess();

        System.out.println("FULL E2E TEST PASSED");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}