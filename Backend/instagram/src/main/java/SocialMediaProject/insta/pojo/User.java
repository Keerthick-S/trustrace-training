package SocialMediaProject.insta.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Document(collection = "UsersCollection")
public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    @Id
    private String id;
    private String instaId;
    private String description;
    private long followers;
    private long following;
    private int posts;
    public User(String id, String instaId, String description) {
        this.id = id;
        this.instaId = instaId;
        this.description = description;
        this.followers = 0;
        this.following = 0;
        this.posts = 0;
    }

    public String getInstaId() {
        return instaId;
    }
    public void setInstaId(String instaId) {
        this.instaId = instaId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFollowing() {
        return following;
    }

    public void setFollowing(long following) {
        this.following = following;
    }
    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
//        logger.info(String.valueOf(noOfPost));
        this.posts = posts;
    }
}
