package SocialMediaProject.insta.repository;

import SocialMediaProject.insta.pojo.Followers;
import SocialMediaProject.insta.pojo.Following;
import SocialMediaProject.insta.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void signup(User user) {
        mongoTemplate.save(user);
        mongoTemplate.save(new Followers(user.getInstaId()));
        mongoTemplate.save(new Following(user.getInstaId()));
    }
    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class);
    }
    public User getUserByInstaId(String instaId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("instaId").is(instaId)), User.class);
    }
    public void deleteUserByInstaId(String instaId){
        mongoTemplate.findAndRemove(Query.query(Criteria.where("instaId").is(instaId)), User.class);
        mongoTemplate.findAndRemove(Query.query(Criteria.where("instaId").is(instaId)), Followers.class);
        mongoTemplate.findAndRemove(Query.query(Criteria.where("instaId").is(instaId)), Following.class);
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
        Query query = new Query();
        User user = mongoTemplate.findOne(Query.query(Criteria.where("instaId").is(instaId)), User.class);
        Update update = new Update();
        update.set("posts", count);
        mongoTemplate.findAndModify(query, update, User.class );
    }
    public void updateFollowingCount(String instaId) {
        Query query = new Query().addCriteria(Criteria.where("instaId").is(instaId));
        Update update = new Update();
        update.inc("following");
        mongoTemplate.findAndModify(query, update, User.class );
    }
    public void updateFollowersCount(String instaId) {
        Query query = new Query().addCriteria(Criteria.where("instaId").is(instaId));
        Update update = new Update();
        update.inc("followers");
        mongoTemplate.findAndModify(query, update, User.class );
    }
}
