
Feature: As a user I need to add a new user to the system


  @TC_001
  Scenario Outline: Successful new user creation
    Given User logs into the system as admin with "<username>" and "<password>"
    When User navigates to the Users page and Click New User button
    And User fills in the First Name as "<name>"
    And User fills in the Last Name as "<lastName>"
    And User fills in the Email as "<email>"
    And User clicks on the Save button
    Then User should see a confirmation message with email "<confirmEmail>"
    Examples:
      | username | password | name  | lastName | email | confirmEmail |
      | fakeone1876@gmail.com | asdqwe123 | Thavindu | Ushan | thavindu19020503@gmail.com | thavindu19020503@gmail.com |
