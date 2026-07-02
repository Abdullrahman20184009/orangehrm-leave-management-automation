# OrangeHRM Leave Management Automation

## Overview

This project was developed as part of a QA Engineering Assessment. It automates a positive end-to-end Leave Management workflow in the OrangeHRM Open Source demo application using Selenium WebDriver.

The framework follows the **Page Object Model (POM)** design pattern and is built with **Java, Selenium WebDriver, TestNG, and Maven**.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

---

## Project Structure

```
src
├── main
└── test
    └── java
        └── com.orangehrm
            ├── base
            ├── pages
            ├── tests
            └── utils
```

---

## Prerequisites

- Java 17 or later
- Maven
- Google Chrome or Microsoft Edge
- Internet connection

---

## How to Run

### Clone the repository

```bash
git clone https://github.com/<your-username>/orangehrm-leave-management-automation.git
```

### Open the project

Open the project using IntelliJ IDEA (or any Java IDE).

### Execute the test

Run the following command:

```bash
mvn clean test
```

Alternatively, execute the `LeaveRequestTest` class directly from IntelliJ IDEA.

---

## Automated Test Scenario

The automated test performs the following workflow:

1. Login as Admin.
2. Create a new employee.
3. Assign leave entitlement.
4. Logout as Admin.
5. Login as the newly created employee.
6. Submit a leave request.
7. Verify the successful submission.

---

## Notes

- Uses explicit waits to improve execution stability.
- Implements the Page Object Model (POM) for maintainability.
- Generates a unique employee for every test execution to avoid duplicate user conflicts.
