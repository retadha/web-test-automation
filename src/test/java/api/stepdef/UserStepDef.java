package api.stepdef;

import api.objects.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDef {

    private User user = new User();


    @Then("response status code is {int}")
    public void responseStatusCodeIs(int code) {
        user.validateResponseStatusCode(code);
    }

    @And("response body match json schema {string}")
    public void responseBodyMatchJsonSchema(String filepath) {
        user.validateJsonSchema(filepath);
    }

    @And("user id is {int}")
    public void userIdIs(int id) {
        user.setId(id);
    }

    @When("hit api get user")
    public void hitApiGetUser() {
        user.getRequest(user.getId());
    }
}
