@LoginFunctionality
@Release01
Feature: Login Functionality

  user story: A user should be able to login with valid credentials

  Background:
    Given User is on the Testifi website
    *     User should see Pets tab


  @SmokeTest
  @PositiveTestCaseTC01
  @TC01-01
  Scenario: Logging in with correct credentials
    *       User enters correct credentials and logs in
    Then    User should see the Home, Pets, and Store tab

  @NegativeTestCaseTC01
  @TC01-02
  Scenario: Logging in with incorrect credentials

    *     User enters incorrect credentials
    *     User clicks the -LogIn- button
    Then  User should see the -Username or password are wrong- error message