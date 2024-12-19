Feature: To verify the Sign-up page functionality of the application

  Scenario: Verify that if user clicks on the "Sign-up for free trial" in login page, he should be redirect to sign-up page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And User should be in sign-up page

  Scenario: Verify the presence of all mandatory fields on the sign-up page.
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify the presence of all mandatory fields on the sign-up page.

  Scenario: Verify that Sign-up page in proper CSS format as per requirement
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that Sign-up page in proper CSS format as per requirement
    And Verify the content of sign-up page

  Scenario: Verify the sign-up page behavior when trying to submit the form with just the Eg:-email field filled out and it has to show validation
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Give only email address and tries to sign-up and it has to show validation

  Scenario: Ensure that error messages are displayed specifically for each empty mandatory field when attempting to submit the form with missing information.
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And verify that if user tries to submit the form without filling it has to show validation for all the fields

  Scenario: Check if the sign-up page provides inline validation for each field, indicating whether the provided information is valid or not as the user fills out the form.
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And verify that if user tries to submit the form with invalid data and it has to show validation for all the fields

  Scenario: Confirm that the sign-up page maintains the data entered in the fields even after a submission attempt with missing information, so users dont need to re-enter valid data.
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that user entering only Account Name and tries to submit and the entered values shouldnt get clear

  Scenario: Ensure that the sign-up page does not allow leading or trailing spaces in mandatory fields (e.g., email)
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that user entering only email with spaces and the space shouldnt accept

  Scenario: Verify that the sign-up page contains placeholder text at mandatory fields
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that the sign-up page contains placeholder text at mandatory fields

  Scenario: Verify that dropdown should provide only Single select option
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that dropdown should provide only Single select option

  Scenario: Verify that if user clicks on the Signin button, user should redirect to Login page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user clicks on the Signin button, user should redirect to Login page

  Scenario: Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page

  Scenario: Verify that OTP verification Page is in proper CSS format as per requirement
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And Verify that OTP verification Page is in proper CSS format as per requirement

  Scenario: Verify that if user enters invalid OTP, it shouldn not accept and it has to show validation
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And Verify that if user enters invalid OTP, it shouldn not accept and it has to show validation

  Scenario: Verify that user can able to resend verification emails if needed.
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And Verify that user can able to resend verification emails if needed.

  Scenario: Verify that if user clicks on the Back to sign-up button in OTP verification page , he should be redirect to Sign-up page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And if user clicks on the Back to sign-up button in OTP verification page , he should be redirect to Sign-up page

  Scenario: Verify that if user clicks on the Signin button in OTP verification page , he should be redirect to Login page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And Verify that if user clicks on the Signin button in OTP verification page , he should be redirect to Login page

  Scenario: Verify that LOGO and content is present in the OTP verification Page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And Verify that LOGO is present in the OTP verification Page

  Scenario: Verify that email should be masked in OTP page
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page
    And Verify that email should be masked in OTP page

  Scenario: Check the response when providing an email address already registered
    Given User should launch the portal by enter the url
    And User should click on the Sign-up for free trial button
    And Check the response when providing an email address already registered
