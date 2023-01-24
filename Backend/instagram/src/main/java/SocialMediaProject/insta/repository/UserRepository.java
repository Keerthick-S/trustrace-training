package SocialMediaProject.insta.repository;

import SocialMediaProject.insta.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class InstaRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void signup(User user) {
        mongoTemplate.save(user);
    }
    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class);
    }
    public User getUserByInstaId(String instaId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("instaId").is(instaId)), User.class);
    }
    public void deleteUserByInstaId(String instaId){
        mongoTemplate.findAndRemove(Query.query(Criteria.where("instaId").is(instaId)), User.class);
    }
    public void updateFollowing(String instaId, String followerInstaId, List<String> followingList) {
        Query query = new Query().addCriteria(Criteria.where("instaId").is(instaId));
        Update update = new Update();
        followingList.add(followerInstaId);
        update.set("followingList", followingList);
        update.set("following", followingList.size());
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void updateFollower(String instaId, String followingInstaId, List<String> followersList) {
        Query query = new Query().addCriteria(Criteria.where("instaId").is(instaId));
        Update update = new Update();
        followersList.add(followingInstaId);
        update.set("followersList", followersList);
        update.set("followers", followersList.size());
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void updateByInstaId(String instaId, User user) {
        Query query = new Query().addCriteria(Criteria.where("instaId").is(instaId));
        Update update = new Update();
        if(user.getInstaId() != null) {
            update.set("instaId", user.getInstaId());
        }
        if(user.getDescription() != null) {
            update.set("description", user.getDescription());
        }
        mongoTemplate.findAndModify(query, update, User.class );
    }
    public void updateNoOfPost(String instaId, int count) {
        Query query = new Query().addCriteria(Criteria.where("instaId").is(instaId));
        Update update = new Update();
        update.set("posts", count);
        mongoTemplate.findAndModify(query, update, User.class );
    }
}
