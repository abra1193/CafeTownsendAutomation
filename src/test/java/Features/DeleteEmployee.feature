#Author: Abraham Mejia
Feature: CafeTownsend DeleteEmployee
  This feature deals with the delete user functionality of the CafeTownSend Portal

  Scenario: Delete an employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user selects an employee from the employee list
    And the user clicks on the Delete button
    Then the user validates the employee was deleted correctly from the CafeTownsend portal employee list
