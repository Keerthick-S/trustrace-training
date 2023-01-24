package SocialMediaProject.insta.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "FollowingCollection")
public class Following {
    private String instaId;
    private List<String> followingList;

    public Following(String instaId) {
        this.instaId = instaId;
        this.followingList = new ArrayList<>();
    }
    public String getInstaId() {
        return instaId;
    }

    public void setInstaId(String instaId) {
        this.instaId = instaId;
    }

    public List<String> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(String followingUser) {
        this.followingList.add(followingUser);
    }
}
