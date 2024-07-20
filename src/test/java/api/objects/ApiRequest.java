package api.objects;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ApiRequest {
    protected final String BASE_URL = "https://gorest.co.in/public/v2";
    protected String endpoint;
    protected Response res;
    private int statusCode;
    private ResponseBody body;


    public ApiRequest(String endpoint) {
        this.endpoint = endpoint;
    }


    public ApiRequest() {
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;

    }

    public void getRequest(int id) {
        this.res = given()
                    .when()
                    .get(BASE_URL + endpoint + "/" + String.valueOf(id))
                    .then().log().all().extract().response();

        this.loadResponse();
    }

    public void loadResponse() {
        this.statusCode = this.res.getStatusCode();
        this.body = this.res.getBody();

    }

    public void validateResponseStatusCode(int code) {
        Assertions.assertEquals(code, this.res.getStatusCode());
    }

    public void validateJsonSchema(String filepath) {
        File scheme = new File(filepath);

        MatcherAssert.assertThat(
                res.getBody().asString(),
                JsonSchemaValidator.matchesJsonSchema(scheme)
        );
    }



}
