Feature: To verify the Login page functionality of the application

  Scenario: Enter URL and click on enter Should launch the portal
    Given User should launch the portal by enter the url
    Then verify user should be in login page

  Scenario: Should display company logo in the middle of login page
    Given User should launch the portal by enter the url
    And verify that LOGO should be there in Login page

  Scenario: Should provide User Name and Password as a free text fields
    Given User should launch the portal by enter the url
    And Provide valid username in Alternative case and enter the valid password
    And it should login into the MTAI application

  Scenario: Should provide Sign In button and Sign In with SSO button to login to the portal
    Given User should launch the portal by enter the url
    And Verify that sign-in button should be there in login page by locating the element
    And Verify that Sign-in with SSO button should be there in login page by locating the element

  Scenario: Click on Sign In with SSO button should land on home page after entering the valid credentials
    Given User should launch the portal by enter the url
    And click on the Sign In with google SSO button
    And Provide valid username and valid password for SSO
    And it should login into the MTAI application homepage

  Scenario: Enter valid user name and password and click on the login should take user to home page
    Given User should launch the portal by enter the url
    And Provide valid username and valid password
    And it should login into the MTAI application homepage

  Scenario: Click on sign out option should take user to login page
    Given User should launch the portal by enter the url
    And Provide valid username and valid password
    And Click on the Sign-out button which is in profile button
    Then verify user should be in login page after logout

  Scenario: Leaving user name and password field blank and click on sign in button should show validation message
    Given User should launch the portal by enter the url
    And click on the sign-in button without entering the credentials
    Then verify that validation message should be displayed at the email and password field

  Scenario: Enter invalid user name and valid password and click on the login should show validation message -Please enter a valid email id- to user
    Given User should launch the portal by enter the url
    And Provide invalid username and valid password
    And Click on the sign-in button
    Then verify validation should be shown as -Please enter a valid email id-

  Scenario: Verify that if user give less than 8 char as password , it has to show validation
    Given User should launch the portal by enter the url
    And Provide valid username and invalid password with less than 8 char
    And Click on the sign-in button
    Then verify validation should be shown as -Please enter a valid password-

  Scenario: Enter valid user name and invalid password and click on the login should show validation message to user
    Given User should launch the portal by enter the url
    And Provide valid username and invalid password
    And Click on the sign-in button
    Then verify validation should be shown as -Incorrect username or password-

  Scenario: Remember me option should be display under password text box along with check box, remember me option should be checked as a default behavior
    Given User should launch the portal by enter the url
    And Provide valid username and valid password for LoginPage
    And verify that remember me option should be checked by default
    And verify that remember me option should be able to check and uncheck
    And Click on the sign-in button
    And it should login into the MTAI application homepage

  Scenario: Provide Eye icon option at right corner of the password text box, once user enter the password. Click on the password should show the password. Again click on the eye icon should hide the password
    Given User should launch the portal by enter the url
    And Provide password with 8 chars
    And Click on Eye icon it should unmask the password and for another click it should mask the password

  Scenario: should be providing Forgot Password option under password text box
    Given User should launch the portal by enter the url
    And verify Forgot Password option under password text box

  Scenario: Click on Forgot Password should open a popup to enter email id
    Given User should launch the portal by enter the url
    And Click Forgot Password option under password text box
    And verify that Forgot Password should open a popup to enter email id

  Scenario: Should provide Submit and Cancel button in reset password popup
    Given User should launch the portal by enter the url
    And Click Forgot Password option under password text box
    And verify that Forgot Password should have Submit and cancel button

  Scenario: Click on Request new password should show "your new password request sent successfully." message and user should get email to change the password
    Given User should launch the portal by enter the url
    And Click Forgot Password option under password text box
    And verify that user has to enter valid email id to get reset password link
    Then Validation message should be emerged - password reset request sent successfully-

  Scenario: Click on Cancel button should cancel the forgot password request
    Given User should launch the portal by enter the url
    And Click Forgot Password option under password text box
    And verify that after clicking cancel button the pop-up should be closed

  Scenario: Login page should be in Proper CSS format as per requirement
    Given User should launch the portal by enter the url
    And Verify that all CSS components are matching with the requirements

  Scenario: Verify that if user tries to login with restricted domain, it has to show validation
    Given User should launch the portal by enter the url
    And User should give restricted domain email and Password in the login page
    And verify that after clicking Sign-in button, validation should be shown

  Scenario: Verify that if user tries to reset the password with restricted domain, it has to show validation
    Given User should launch the portal by enter the url
    And User should give restricted domain email in the Forgot password pop-up
    And verify that after clicking Submit button, validation should be shown

  Scenario: Verify that State should be refreshed in the Forgot Password pop-up
    Given User should launch the portal by enter the url
    And User should give restricted domain email in the Forgot password pop-up
    And verify that after clicking Submit button, validation should be shown
    And user should click the close icon in Forgot password pop-up
    And Again user should click on Forgot password button, the validation should be removed

  Scenario: If user clicks on the Privacy policy & Terms of use, it has to redirect to that page
    Given User should launch the portal by enter the url
    And User should click on the clicks on the Privacy policy & Terms of use
    And verify that it has been properly redirected to corresponding page

  Scenario: Verify that if user clicks on the MadTechAI LLC, it has to redirect to MAdTechAI webpage in a new tab
    Given User should launch the portal by enter the url
    And User should click on the clicks on the MadTechAI LLC
    And verify that it has been properly redirected to MadTechAI webpage

  Scenario: If user clicks on the "Sign-up for free trial" , it has to redirect to sign-up page
    Given User should launch the portal by enter the url
    And User should click on the clicks on the Sign-up for free trial button
    And verify that it has been properly redirected to Sign-up page

  Scenario: Verify that for direct Client, instaed of "Sign-up for free trial", "Sign-up" should be there
    Given User should launch the portal by enter the custom url
    And User should locate the Sign-up naming

  Scenario: Verify that for direct client other than registered domain should not be allowed
    Given User should launch the portal by enter the custom url
    And User should give other than registered domain
    And verify that it has to show validation -Please use registered mail id-

  Scenario: Verify that for direct client only registered domain should be allowed
    Given User should launch the portal by enter the custom url
    And User should give registered domain
    And verify that it has to accept the registered mail id

  Scenario: If user tries to sign-in with invalid SSO mail, it shouldnt login into application for direct client
    Given User should launch the portal by enter the custom url
    And user should click on the Sign-in with google and enter invalid credentials
    Then user should be redirected to login page

  Scenario: If user tries to sign-in with valid SSO mail for direct client, it should login into application
    Given User should launch the portal by enter the custom url
    And user should click on the Sign-in with linkedin and enter valid credentials
    Then user should be redirecting to homepage
