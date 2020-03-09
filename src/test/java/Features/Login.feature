#Author: Abraham Mejia
Feature: CafeTownSend Login
  This feature deals with the login functionality of the CafeTownSend Portal

  Scenario: CafeTownSend login
    Given the user navigates to the login page
    When the user types the credentials provided on the portal
    Then the user login on the CafeTownsend Portal successfully

  Scenario: CafeTownSend invalid login
    Given the user navigates to the login page
    When the user types a wrong credentials on the login page
    Then the portal display a invalid credentials warning on the login page