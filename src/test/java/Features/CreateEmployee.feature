#Author: Abraham Mejia
Feature: CafeTownsend CreateEmployee
  This feature deals with the create user functionality of the CafeTownSend Portal

  Scenario : Create an employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user clicks on the Create button
    And the user types the data to create the new employee
      | FirstName | LastName     | StartDate  | Email              |
      | TestName  | TestLastName | 2020-01-01 | testemail@test.com |
    Then the new employee created is displayed on the employee list
    And the user validates the employee data was inserted correctly on the CafeTownsend portal


  Scenario: Create an employee with missing fields on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user clicks on the Create button
    And the user types the data to create the new employee
      | FirstName | LastName     | Email              |
      | TestName  | TestLastName | testemail@test.com |
    But the portal displays a missing field warning


