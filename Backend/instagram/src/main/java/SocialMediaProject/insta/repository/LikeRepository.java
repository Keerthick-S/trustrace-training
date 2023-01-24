package SocialMediaProject.insta.repository;

import SocialMediaProject.insta.pojo.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void postLike(String postId, String instaId) {
        Query query = new Query().addCriteria(Criteria.where("postId").is(postId));
        Update update = new Update();
        update.push("likeList", instaId);
        mongoTemplate.findAndModify(query, update, Like.class);
    }
    public void postUnlike(String postId, String instaId) {
        Query query = new Query().addCriteria(Criteria.where("postId").is(postId));
        Update update = new Update();
        update.pull("likeList", instaId);
        mongoTemplate.findAndModify(query, update, Like.class);
    }

}
