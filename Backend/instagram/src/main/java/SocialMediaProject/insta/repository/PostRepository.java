package SocialMediaProject.insta.repository;

import SocialMediaProject.insta.pojo.Like;
import SocialMediaProject.insta.pojo.Post;
import SocialMediaProject.insta.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    public void createPost(Post post) {
        mongoTemplate.save(new Like(post.getId()));
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
        Post post = mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Post.class);
        return post;
    }
    public void updateView(String id, Post post) {
        Query query = new Query().addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("views", post.getViews()+1);
        logger.info(String.valueOf(post.getViews()+1));
        mongoTemplate.findAndModify(query, update, Post.class );
    }
    public List<Post> getTopPost(int page, int limit) {
        Query query = new Query().skip(page * limit).limit(limit).with(Sort.by(Sort.Direction.DESC,"views"));
        return mongoTemplate.find(query, Post.class);
    }
}
