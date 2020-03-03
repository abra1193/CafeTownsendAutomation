#Author: Abraham Mejia
Feature: CafeTownsend CreateEmployee
  This feature deals with the create user functionality of the CafeTownSend Portal

  Scenario: Create an employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user clicks on the Create button
    And the user types the data to create the new employee
    Then the new employee created is displayed on the employee list
    And the user validates the employee data was inserted correctly on the CafeTownsend portal


  Scenario: Create an employee with missing fields on the CafeTownsend portal
    Given the user login on the CafeTownsend portal for second time
    When the user clicks on the Create button for second time
    And the user types the data to create the new employee for second time
    But the portal displays a missing field warning


