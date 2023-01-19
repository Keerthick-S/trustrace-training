package SocialMediaProject.insta.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "PostCollection")
public class Post {
    @Id
    private String id;
    private String post;
    private String postDescription;
    private LocalDateTime timeAndDate;
    private String instaId;

    public Post(String id, String postDescription, String post, LocalDateTime timeAndDate, String instaId) {
        this.id = id;
        this.postDescription = postDescription;
        this.post = post;
        this.timeAndDate = timeAndDate;
        this.instaId = instaId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDateTime getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(LocalDateTime timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    public String getInstaId() {
        return instaId;
    }

    public void setInstaId(String instaId) {
        this.instaId = instaId;
    }
}
