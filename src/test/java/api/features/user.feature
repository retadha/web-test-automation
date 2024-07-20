Feature: User
  @api
  Scenario: Get User
    Given user id is 7051174
    When hit api get user
    Then response status code is 200
    And response body match json schema "src/test/java/api/schemes/UserSchema.json"
