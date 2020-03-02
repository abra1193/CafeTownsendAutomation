#Author: Abraham Mejia
Feature: CafeTownsend Logout
  This feature deals with the logout functionality of the CafeTownsend Portal

  Scenario: CafeTownSend logout
    Given the user is login on the CafeTownsend Portal
    When the user clicks on the logout button
    Then the user is logout from the CafeTownsend Portal