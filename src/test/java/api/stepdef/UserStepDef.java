package api.stepdef;

import api.objects.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDef {

    private User user = new User();


    @Then("response status code is {int} for user api request")
    public void responseStatusCodeIs(int code) {
        user.validateResponseStatusCode(code);
    }

    @And("response body match {string} for user api request")
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

    @Given("user name is {string}")
    public void userNameIs(String name) {
        user.setName(name);
    }

    @And("user gender is {string}")
    public void userGenderIs(String gender) {
        user.setGender(gender);
    }

    @And("user email is {string}")
    public void userEmailIs(String email) {
        user.setEmail(email);
    }

    @And("user status is {string}")
    public void userStatusIs(String status) {
        user.setStatus(status);
    }

    @When("hit api create user")
    public void hitApiCreateUser() {
        user.createUser();
    }

    @When("hit api update user")
    public void hitApiUpdateUser() {
        user.updateUser();

    }

    @When("hit api delete user")
    public void hitApiDeleteUser() {
        user.deleteUser();
    }

    @And("user name in response is {string}")
    public void userNameInResponseIs(String name) {
        user.validateName(name);
    }


}
