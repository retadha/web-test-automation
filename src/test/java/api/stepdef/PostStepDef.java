package api.stepdef;

import api.objects.Post;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostStepDef {

    Post post = new Post();

    @When("hit api get posts")
    public void hitApiGetPosts() {
        post.getPosts();
    }

    @Then("response status code is {int} for post api request")
    public void responseStatusCodeIsForPostApiRequest(int code) {
        post.validateResponseStatusCode(code);
    }

    @And("response body match {string} for post api request")
    public void responseBodyMatchForPostApiRequest(String filepath) {
        post.validateJsonSchema(filepath);
    }
}
