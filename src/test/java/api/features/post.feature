@api
Feature: Post

  Scenario: Get Posts
    When hit api get posts
    Then response status code is 200 for post api request
    And response body match "src/test/java/api/schemes/PostsSchema.json" for post api request