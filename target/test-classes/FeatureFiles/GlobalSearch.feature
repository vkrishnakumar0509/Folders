Feature: To verify the Global Search functionality of the application

  Scenario: Verify that Searchbox should be there in header, if user search any features under left menu, it should fetch results
    Given User should launch the portal by enter the url
    And User should login into the application
    And Searchbox should be there in header, if user search any features under left menu, it should fetch results

  Scenario: Verify that if user search invalid data, it has to show No results found message
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user search invalid data, it has to show No results found message

  Scenario: Verify that if user clears the search texts, it has to show all features as per requirement
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clears the search texts, it has to show all features as per requirement

  Scenario: Verify that Placeholder is available in Searchbox to identify by end user
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that Placeholder is available in Searchbox to identify by end user

  Scenario: Verify that search feature should be given to end user based upon the role as well as module management
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that search feature should be given to end user based upon the role as well as module management

  Scenario: If user search other than assigned feature, it has to show no results found
    Given User should launch the portal by enter the url
    And User should login into the application
    And If user search other than assigned feature, it has to show no results found

  Scenario: Verify that proper Icon should be provided for each feature
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that proper Icon should be provided for each feature

  Scenario: Verify that proper description should be provided for each feature
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that proper description should be provided for each feature

  Scenario: Verify that if user clicks on any of the feature which is fetched from search results, it should redirect to that page
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on any of the feature which is fetched from search results, it should redirect to that page

  Scenario: Verify that if user search for any of the assigned dashboards, it should fetch results
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user search for any of the assigned dashboards, it should fetch results

  Scenario: Verify that if user clicks on the dashboard, it should redirect to that dashboard
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the dashboard, it should redirect to that dashboard

  Scenario: Verify that after unassigning the dashboards, if user search for that dashboard it should not fetch results
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that after unassigning the dashboards, if user search for that dashboard it should not fetch results

  Scenario: Verify that if user search for internal features like Executive summary and dashboard widgets it should show No results found
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user search for internal features like Executive summary and dashboard widgets it should show No results found

  Scenario: Verify that if user search for Parent feature, it has to show all the child features as well
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user search for Parent feature, it has to show all the child features as well

  Scenario: Verify that user can access the Searchbox from any of the webpage in portal
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that user can access the Searchbox from any of the webpage in portal

  Scenario: Client havent any dashboards, and if he clicks on the Dashboards in search dropdown, it should show validation in toaster
    Given User should launch the portal by enter the url
    And User should login into the application using no dashboard account
    And Client havent any dashboards, and if he clicks on the Dashboards in search dropdown, it should show validation in toaster

  Scenario: Verify that Direct client and trial client should have the search functionality feature which should function as per requirement
    Given User should launch the portal by enter the direct client url
    And User should login into the application using direct client account
    And Verify that Direct client and trial client should have the search functionality feature which should function as per requirement

  Scenario: Verify that for Superadmin, if user search for Support, New request, Feedback feature, it should show No results found
    Given User should launch the portal by enter the url
    And User should login into the application using SA account
    And Verify that for Superadmin, if user search for Support, New request, Feedback feature, it should show No results found

  Scenario: Verify that for user role, Administration & iPaaS feature should not be there
    Given User should launch the portal by enter the url
    And User should login into the application using user account
    And Verify that for user role, Administration & iPaaS feature should not be there
