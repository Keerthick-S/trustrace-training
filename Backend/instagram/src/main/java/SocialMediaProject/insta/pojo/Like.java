package SocialMediaProject.insta.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "LikeCollection")
public class Like {
    private String postId;
    private List<String> likeList;

    public Like(String postId) {
        this.postId = postId;
        likeList = new ArrayList<>();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public List<String> getLikeList() {
        return likeList;
    }

    public void setLikeList(String instaId) {
        likeList.add(instaId);
    }
}
