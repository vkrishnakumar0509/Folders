@smoke
Feature: To verify the Folders Sub-Folders functionality of the application

  Scenario: Verify that if I create new client and logging into application, No dashboard assigned to you message should be displayed
    Given User should launch the portal by enter the url
    And User should login into the application using no dashboard account
    And Verify that if I create new client and logging into application, No dashboard assigned to you message should be displayed

  Scenario: Verify that Folder management should be in proper CSS format as per requirement
    Given User should launch the portal by enter the url
    And User should login into the application using no dashboard account
    And Verify that Folder management should be in proper CSS format as per requirement

  Scenario: Verify that if there is dashboard assigned to the Client, it has to show Corresponding dashboard under the DASHBOARDS folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if there is dashboard assigned to the Client, it has to show Corresponding dashboard under the DASHBOARDS folder

  Scenario: Verify that DASHBOARDS folder should have an dropdown which should hide/unhide the dashboards and folders
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that DASHBOARDS folder should have an dropdown which should hide/unhide the dashboards and folders

  Scenario: Verify that Folder management features available only to the client admin account and super admin account
    Given User should launch the portal by enter the url
    And User should login into the application using SA account
    And Verify that Folder management features available only to the client admin account and super admin account

  Scenario: Verify that if user clicks action near to the folder name, it has to appear Actions dropdown near to the folder at the right cornor
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks action near to the folder name, it has to appear Actions dropdown near to the folder at the right cornor

  Scenario: Verify that if user again clicks on the Actions near to the folder name, it has to dis-appear Actions dropdown near to the folder at the right cornor
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user again clicks on the Actions near to the folder name, it has to dis-appear Actions dropdown near to the folder at the right cornor

  Scenario: Verify that if user clicks on the Actions icon at the DASHBOARDS folder name, it has to show the following Select dropdown values New folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Actions icon at the DASHBOARDS folder name, it has to show the following Select dropdown values New folder

  Scenario: Verify that If user clicks on the Add Folder, it has to open the Textbox in the left menu to enter the Folder name
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that If user clicks on the Add Folder, it has to open the Textbox in the left menu to enter the Folder name

  Scenario: Verify that if user clicks on the Cancel or Close button, the pop-up should be closed
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Cancel or Close button, the pop-up should be closed

  Scenario: Verify that user after enters the New Folder name and clicks on the save button, it should be saved
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that user after enters the New Folder name and clicks on the save button, it should be saved

  Scenario: Verify that if user didn't give folder name, and tries to save, it has to show validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user didn't give folder name, and tries to save, it has to show validation

  Scenario: Verify that if user tries to create new folder with Existing name, it has to show validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user tries to create new folder with Existing name, it has to show validation

  Scenario: Verify that while creating the new folder, need to restrict the character limit to thirty
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that while creating the new folder, need to restrict the character limit to thirty

  Scenario: Verify that if user clicks on the "Actions" near to the Folder, it has to show the following options "Add folder, Move folder, Rename folder, Delete Folder"
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Actions near to the Folder, it has to show the following options Add folder, Move folder, Rename folder, Delete Folder

  Scenario: Verify that if user clicks on the "Add folder", and after creating a new folder it should be created as Child Folder which should be under the Parent Folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Add folder, and after creating a new folder it should be created as Child Folder which should be under the Parent Folder

  Scenario: Verify that if user clicks on the Move Folder option, a pop-up should be emerge in the name of Select the destination folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Move Folder option, a pop-up should be emerge in the name of Select the destination folder

  Scenario: Verify that if user clicks on Close and Cancel button in the pop-up , the Select a destination folder pop-up should be closed
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on Close and Cancel button in the pop-up , the Select a destination folder pop-up should be closed

  Scenario: Verify that if user didn't select the destination folder and clicks on the move button, it has to show the validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user didn't select the destination folder and clicks on the move button, it has to show the validation

  Scenario: Verify that Select a destination folder pop-up should list all the Folders which is catagorized in the Client's account
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that Select a destination folder pop-up should list all the Folders which is catagorized in the Client's account

  Scenario: Verify that Select a destination folder pop-up shouldn't show the dashboards
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that Select a destination folder pop-up shouldn't show the dashboards

  Scenario: Verify that the folder selection should be single select
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that the folder selection should be single select

  Scenario: Verify that if user gives same folder name in Same Parent/ Child level, it has to show the validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user gives same folder name in Same Parent/ Child level, it has to show the validation

  Scenario: Verify that if user clicks on the Rename Folder, Edit folder pop-up should be emerged
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Rename Folder, Edit folder pop-up should be emerged

  Scenario: Verify that if user clicks on the Cancel or Close button,in the rename pop-up should be closed
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Cancel or Close button,in the rename pop-up should be closed

  Scenario: Verify that if user didnt give any name, it has to show validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user didn't give any name, it has to show validation

  Scenario: Verify that if user gives existing name in rename pop-up, it has to show the validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user gives existing name in rename pop-up, it has to show the validation

  Scenario: Verify that if user gives new name and clicks on the Update, the folder name should be renamed
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user gives new name and clicks on the Update, the folder name should be renamed

  Scenario: Verify that if clicks on the Delete Folder at the particular folder, the confirmation pop-up should be emerged Delete Folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if clicks on the Delete Folder at the particular folder, the confirmation pop-up should be emerged Delete Folder

  Scenario: Verify that if user clicks on the "Cancel" & "Close" button , the pop-up should be closed
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Cancel&Close button , delete folder the pop-up should be closed

  Scenario: Verify that if user clicks on the Submit button, the folder should be deleted
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Submit button, the folder should be deleted

  Scenario: Verify that state should be refreshed in the all the pop-up
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that state should be refreshed in the all the pop-up

  Scenario: Verify that if user clicks on action button near to the dashboard ,he can get the option Add to Folder and Move file
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on action button near to the dashboard ,he can get the option Add to Folder and Move file

  Scenario: Verify that if user clicks on the Add to Folder , a pop-up should be emerged to create new folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Add to Folder , a pop-up should be emerged to create new folder

  Scenario: Verify that if user clicks on the Move file button , a pop-up should be emerged to select the destination folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user clicks on the Move file button , a pop-up should be emerged to select the destination folder

  Scenario: Verify that if user tries to move the dashboard to same folder , it should show the validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user tries to move the dashboard to same folder , it should show the validation

  Scenario: Verify that if user tries to move the dashboard to same folder , it should show the validation
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user tries to move the dashboard to same folder , it should show the validation

  Scenario: Verify that font-family and background color should change based upon the client settings
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that font-family and background color should change based upon the client settings

  Scenario: Verify that after deleting the folder, if user creates the new folder with the same name, it should be created
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that after deleting the folder, if user creates the new folder with the same name, it should be created

  Scenario: Verify that user can able to create maximum of 3 sub-folder under parent folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that user can able to create maximum of 3 sub-folder under parent folder

  Scenario: Verify that if user does mouse hover action for the hided foldername, it has to show the entire name of the Folder
    Given User should launch the portal by enter the url
    And User should login into the application
    And Verify that if user does mouse hover action for the hided foldername, it has to show the entire name of the Folder
