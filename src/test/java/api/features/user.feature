@api
Feature: User

  Scenario: Get User
    Given user id is 7051174
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

