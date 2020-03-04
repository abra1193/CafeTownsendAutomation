#Author: Abraham Mejia
Feature: CafeTownsend EditEmployee
  This feature deals with the edit user functionality of the CafeTownSend Portal

  Scenario: Edit an employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user selects an employee from the employee list
    And the user clicks on the Edit button
    And the user edits an employee
    Then the user validates the employee data was edited correctly on the CafeTownsend portal






