package api.objects;

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

    public void getUser(int id) {
        this.getRequest(id);

    }




}
