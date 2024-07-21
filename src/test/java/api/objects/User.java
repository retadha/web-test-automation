package api.objects;

import io.restassured.internal.common.assertion.Assertion;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class User extends ApiRequest {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;



    public User(int id) {
        this.id = id;
    }

    public User(String endpoint) {
        this.endpoint = endpoint;
    }

    public User() {
        this.setEndpoint("/users");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getJson() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", this.email);
        jsonObject.put("name", this.name);
        jsonObject.put("gender", this.gender);
        jsonObject.put("status", this.status);

        return jsonObject.toString();
    }



    public void getUser(int id) {
        this.getRequest(id);

    }

    public void createUser() {
        this.postRequest(this.getJson());
    }

    public void updateUser() {
        this.patchRequest(this.getId(), this.getJson());
        this.loadData();

    }

    public void deleteUser() {
        this.deleteRequest(this.getId());
    }

    private void loadData() {
        this.id = this.res.jsonPath().getInt("id");
        this.name = this.res.jsonPath().getString("name");
        this.email = this.res.jsonPath().getString("email");
        this.gender = this.res.jsonPath().getString("gender");
        this.status = this.res.jsonPath().getString("status");

        System.out.println("Loaded data");
        System.out.println(this.getJson());
    }

    public void validateName(String name) {
        Assertions.assertEquals(name, this.getName());
    }




}
