package SocialMediaProject.insta.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "FollowersCollection")
public class Followers {
    private String instaID;
    private List<String> followersList;
    public Followers(String instaID) {
        this.instaID = instaID;
        this.followersList = new ArrayList<>();
    }
    public String getInstaID() {
        return instaID;
    }
    public List<String> getFollowersList() {
        return followersList;
    }
    public void setInstaID(String instaID) {
        this.instaID = instaID;
    }
    public void setFollowersList(String follower) {
        this.followersList.add(follower);
    }
}
