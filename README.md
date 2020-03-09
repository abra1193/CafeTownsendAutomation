# CafeTownsend automation tests

## Test Approach

The tests were created with a black box testing approach,every test run inserts certain parameters on the portal expecting that the outcome is the one expected,this last part was accomplished with assertions of the parameters inserted on the portal depending on what is asked on the test case.

Since this I decided to create parameterized test and those parameters are stored on the src/test/java/testng.xml file,this file contains all the variables used on the test execution,these parameters can be changed on this file,right now there are default.

**The four main function covered on the testing are:**

 * Create
 * Edit
 * Delete 
 * Login
 * Logout

 **Six Scenarios are created for this automated test suite:**

* Create employee on the CafeTownsend portal

* Delete employee on the CafeTownsend portal

* Edit employee on the CafeTownsend portal

* Login on the CafeTownsend portal

* Logout on the CafeTownsend portal

**Note:** Test scenarios are described in the feature files on the src/test/java/Features path.

**The following test case are cover by the automation test suite:**


*  **Verify that the user can create an employee on the portal(CreateEmployeeTest.java).**

   **Expected result:** The employee is displayed on the employee list with the same data that was created.
  

*  **Verify that the user can edit an employee on the portal(EditEmployeeTest.java).**

   **Expected result:** The employee is displayed on the employee list with the same data that was edited.
  

* **Verify that the user can delete an employee on the portal(DeleteEmployeeTest.java).**

  **Expected result:** The employee is not longer displayed on the employee list.
  

* **Verify that the user can login on the portal(LoginTest.java).**

  **Expected result:** Login greeting message is displayed on the home screen.
  

* **Verify that the user can logout of the portal(LogoutTest.java).**

  **Expected result:** After the user is logout of the portal,the login page is displayed.
  

* **Verify when the user enters invalid credentials on the login page(InvalidLoginTest.java).**

  **Expected result:** The portal display a warning message on the login page.

## Pre Requisites


### Windows ###

Step 1:

Install JDK and set the Java home variable on your machine

Follow instructions [here](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)

Step 2: 

Install Maven 3.6.3

Download from [here](http://maven.apache.org/download.cgi)

Step 3: 

Ensure maven binaries are on your PATH (ie. you can run mvn from anywhere)

Follow the installation instructions from here [here](https://mkyong.com/maven/how-to-install-maven-in-windows/).

### MacOS ###

Step 1:

Install JDK

Follow instructions [here](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-F575EB4A-70D3-4AB4-A20E-DBE95171AB5F)

Step 2: Install Maven with below command

brew install maven


## How to execute the tests cases via Maven

**Note: All the tests use WebdriverManager so its no needed to have a local browser driver.**

1. Clone/Download the project from this github repository

2. Navigate to the folder CafeTownsendAutomation using your OS terminal

3. For execute the complete test suite,run the following command on the terminal:

    `mvn test compile`

4. For execute individual tests,run one of the following command on the terminal:

 #### Login on the CafeTownsend portal ####
`mvn test -Dtest=LoginTest -Duser=Luke -Dpassword=Skywalker`

`mvn test -Dtest=InvalidLoginTest -Duser=Luke -Dpassword=Skywalker`

 #### Logout on the CafeTownsend portal ####

`mvn test -Dtest=LogoutTest -Duser=Luke -Dpassword=Skywalker`

 #### Create employee on the CafeTownsend portal ####

`mvn test -Dtest=CreateEmployeeTest -Duser=Luke -Dpassword=Skywalker -DfirstnameCreate=CREATE -DlastnameCreate=USER -DstartdateCreate=2020-01-01 -DemailCreate=CREATEUSER@test.com`

 #### Edit employee on the CafeTownsend portal ####

`mvn test -Dtest=EditEmployeeTest -Duser=Luke -Dpassword=Skywalker -DfirstnameCreate=EDIT -DlastnameCreate=USER -DstartdateCreate=2020-01-01 -DemailCreate=EDITUSER@test.com -Dnewfirstname=NEWNAME -Dnewlastname=NEWLASTNAME -Dnewstartdate=2020-01-01 -Dnewemail=NEWNAME@test.com` 

 #### Delete employee on the CafeTownsend portal ####

`mvn test -Dtest=DeleteEmployeeTest -Duser=Luke -Dpassword=Skywalker -DfirstnameCreate=DELETE -DlastnameCreate=USER -DstartdateCreate=2020-01-01 -DemailCreate=DELETEUSER@test.com`

## Languages,framework and structure ##

This Maven project is developed using **Java 1.8** with **Selenium WebDriver framework**,**TestNG** as the testing framework and **Cucumber** as the BDD language approach.

For the test code structure the Page Object Model was used for better code reusability,maintainability of the testing framework.Every Cafetownsend's screen was created as a java class(Employees,Home and Login page) and it those class are stored the screens webelements and several methods for interactions on the portal and also a PageGenerator class is available for maintaining every actual screen or others that will be added in the future on the portal.

The test scenarios were created with Cucumber following the Behavior Driven Development principles.

The project has a maven POM.xml file that has the build configurations,dependencies and plugins necessary to execute the project.

The project is divided on folders(Java Packages),each folder represent an abstraction layer,the folders name are as follow:
 
* **Base** : BasePage is located here,in this super class I created the principal methods for navigation on the portal like wait,click and write and all this method are inherited to every actual page class and can be inherited to future page classes.

* **Features** : Cucumber Feature scenarios files are located here(Create,delete and edit employee,Login and Logout),in these file I define our the test scenarios that will be tested in this framework.

* **Pages** : Every Cafetownsend's screen is defined here as a java class(Employees,Home and Login page) and in those classes are stored the screens webelements and several methods for interactions on the portal and in this folder there is also a PageGenerator class for maintaining every actual screen or others that will be added in the future on the portal,in this class I declare every portal initialization as a method that will return the portal on the **Pages** folder as fully page object initialized.

* **Resources** : Here is where the testng.xml file is located,in this file are stored the test suite definition and the parameters that the tests are going to used in the test executions.

* **Resources** : testng.xml file is located here,in this file are stored the test suite definition and the parameters that the tests are going to used in the test executions.

* **Tests** : Here is where the testcases classes with the excecution steps are located(CreateEmployeeTest,DeleteEmployeeTest,EditEmployeeTest,InvalidLoginTest,LoginTest and LogoutTest) and also here is located the super class BaseTest where the variables and configurations of the testing are contained(Testing browser and driver configurations) and all Test classes extend this BaseTest superclass. 

    A method called selectEmployee(Java list) was created for store the users located on the home page employee list and with this list we can easily find and select employees on the the employee list,this list store all li tags on the employee list and then we iterate every li tag stored on the list until it fulfills the condition of the given name on the method,I decided this since it will be very dificult to select or find a name with a simple xpath,since the employee can grow bigger and bigger with the time and in the future another element can intercept that click,so iterating the li tags will be more efficient.

  A method called validateDeletedEmployee(Java list) was created for store the users located on the home page employee list and with this list we can easily verify if an employee is not longer available on the employee list,this list store all li tags on the employee list and then we iterate every li tag stored on the list until it fulfills the condition with the given name on the method,I decided this since it will be very dificult to select or find a name with a simple xpath,since the employee can grow bigger and bigger with the time and in the future another element can intercept that click,so iterating the li tags will be more efficient.
