Feature: Checking Login Functionality with Invalid Username

  Scenario: Login with Invalid UserName
   Given User should open Chrome Browser
   When User should Enter url in Browser
   And User should Navigate Home Page
   And Enter Invalid Username and Valid Password in Edit Box
   And Click On Login PushButton
   Then Error Message should be displayed
   And Verify Invalid Username Error Message
