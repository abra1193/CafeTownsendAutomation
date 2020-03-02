#Author: Abraham Mejia
Feature: CafeTownsend EditEmployee
  This feature deals with the edit user functionality of the CafeTownSend Portal

  Scenario: Edit an employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user selects an employee from the employee list
    And the user clicks on the Edit button
    And the user edits an employee
      | FirstName      | LastName           | StartDate  | Email                          |
      | TestNameEdited | TestLastNameEdited | 2020-11-11 | testemailedited@testedited.com |
    Then the user validates the employee data was edited correctly on the CafeTownsend portal

  Scenario: Edit a missing fields employee on the CafeTownsend portal
    Given the user login on the CafeTownsend portal
    When the user clicks on the Edit button button
    And the user edits a missing fields employee
      | FirstName      | LastName           | Email                          |
      | TestNameEdited | TestLastNameEdited | testemailedited@testedited.com |
    But the portal displays a missing field warning





