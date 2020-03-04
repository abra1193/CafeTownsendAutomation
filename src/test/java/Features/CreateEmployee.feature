#Author: Abraham Mejia
Feature: CafeTownsend CreateEmployee
  This feature deals with the create user functionality of the CafeTownSend Portal

  Scenario: Create an employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user clicks on the Create button
    And the user types the data to create the new employee
    Then the new employee created is displayed on the employee list
    And the user validates the employee data was inserted correctly on the CafeTownsend portal



