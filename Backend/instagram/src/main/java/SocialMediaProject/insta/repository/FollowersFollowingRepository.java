package SocialMediaProject.insta.repository;

import SocialMediaProject.insta.pojo.Followers;
import SocialMediaProject.insta.pojo.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FollowersFollowingRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void updateFollowing(String instaId, String toFollowInstaId) {
        Following obj = mongoTemplate.findOne(Query.query(Criteria.where("instaId").is(instaId)),Following.class);
        obj.setFollowingList(toFollowInstaId);
        Update update = new Update();
        update.set("followingList", obj.getFollowingList());
        mongoTemplate.findAndModify(Query.query(Criteria.where("instaId").is(instaId)), update, Following.class);
    }
    public void updateFollowers(String instaId, String followingInstaId) {
        Followers obj = mongoTemplate.findOne(Query.query(Criteria.where("instaID").is(instaId)),Followers.class);
        obj.setFollowersList(followingInstaId);
        Update update = new Update();
        update.set("followersList", obj.getFollowersList());
        mongoTemplate.findAndModify(Query.query(Criteria.where("instaID").is(instaId)), update, Followers.class);
    }
    public List<String> getFollowingByInstaId(String instaId) {
        Following temp = mongoTemplate.findOne(Query.query(Criteria.where("instaId").is(instaId)),Following.class);
        return temp.getFollowingList();
    }
    public List<String> getFollowersByInstaId(String instaId) {
        Followers temp = mongoTemplate.findOne(Query.query(Criteria.where("instaId").is(instaId)), Followers.class);
        return temp.getFollowersList();
    }
}
