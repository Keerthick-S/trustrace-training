package SocialMediaProject.insta.repository;

import SocialMediaProject.insta.pojo.Post;
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
    public void createPost(Post post) {
        mongoTemplate.save(post);
    }

    public List<Post> userAllPost(String instaId) {
        return mongoTemplate.find(Query.query(Criteria.where("instaId").is(instaId)), Post.class);
    }
    public List<Post> getAllPost() {
        return mongoTemplate.findAll(Post.class);
    }

    public void deletePost(String id) {
        mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), Post.class);
    }
    public Post getPost(String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Post.class);
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
        update.set("post", count);
        mongoTemplate.findAndModify(query, update, User.class );
    }
}
