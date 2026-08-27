Feature: Login User with Invalid Password

Scenario: Login with Invalid Password

Given User should Launch Chrome browser
When User should Navigate to url 'https://practicetestautomation.com/practice-test-login/'
Then Enter username 'student'
And Enter password 'incorrectPassword'
And Click 'Submit' button
Then Verify error message is displayed
And Verify error message text is 'Your password is invalid!'