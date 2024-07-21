package api.objects;

public class Post extends ApiRequest{
    private int id;
    private int userId;
    private String title;
    private String body;

    public Post() {
        this.setEndpoint("/posts");
    }

    public void getPosts() {
        this.getRequest();
    }




}
