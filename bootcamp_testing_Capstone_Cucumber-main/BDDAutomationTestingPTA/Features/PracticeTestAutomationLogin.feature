Feature: Checking Login Functionality

  Scenario: Login with Valid Credentials
    Given User should open Chrome Browser
    When User should Enter url in Browser
    And User should Navigate Home Page
    And Enter Username and Password in Edit Box
    And Click On Login PushButton
    Then Message displayed Login Successfully
