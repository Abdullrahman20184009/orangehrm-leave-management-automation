# OrangeHRM Leave Management Automation

## Overview

This project contains an end-to-end Selenium automation test for the OrangeHRM Open Source demo application.

The automated scenario covers:

- Login as Admin
- Create a new Employee
- Assign Leave Entitlement
- Logout as Admin
- Login as the created Employee
- Submit a Leave Request
- Verify successful submission

The project follows the Page Object Model (POM) design pattern and is built using Java, Selenium WebDriver, TestNG, and Maven.

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
             ├── pages
             ├── tests
             └── utils
```

---

## Prerequisites

- Java 17 or later
- Maven
- Google Chrome
- Internet connection

---

## How to Run

Clone the repository:

```bash
git clone <repository-url>
```

Open the project in IntelliJ IDEA.

Run:

```
mvn clean test
```

or execute the TestNG test directly from IntelliJ.

---

## Test Scenario

1. Login as Admin
2. Create a new employee
3. Assign leave entitlement
4. Logout
5. Login as the created employee
6. Submit a leave request
7. Verify the success confirmation
