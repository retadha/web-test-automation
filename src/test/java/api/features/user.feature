@api
Feature: User

  Scenario: Get User
    Given user id is 7051172
    When hit api get user
    Then response status code is 200
    And response body match json schema "src/test/java/api/schemes/UserSchema.json"

   Scenario: Create User
     Given user name is "Dummy User"
     And user gender is "male"
     And user email is "dummy@user.com"
     And user status is "active"
     When hit api create user
     Then response status code is 201
     And response body match json schema "src/test/java/api/schemes/UserSchema.json"

  Scenario: Create User Without Status
    Given user name is "Dummy User"
    And user gender is "male"
    And user email is "dummy@user2.com"
    When hit api create user
    Then response status code is 422
    And response body match json schema "src/test/java/api/schemes/FailCreateUserSchema.json"

  Scenario: Create User With Invalid Format
    Given user name is "Dummy User"
    And user gender is "unknown"
    And user email is "dummy@user3.com"
    And user status is "unknown"
    When hit api create user
    Then response status code is 422
    And response body match json schema "src/test/java/api/schemes/FailCreateUserSchema.json"

  Scenario: Update User
    Given user id is 7051172
    And user name is "Fake User"
    When hit api update user
    Then response status code is 200
    And  user name in response is "Fake User"
    And response body match json schema "src/test/java/api/schemes/UserSchema.json"

  Scenario: Delete User
    Given user id is 7051169
    When hit api delete user
    Then response status code is 204


