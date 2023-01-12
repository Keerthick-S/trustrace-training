package com.Trustrace.Usercrud.repository;

import com.Trustrace.Usercrud.pojo.User;
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
    private Query foundUserId;

    public void create(User user) {
        mongoTemplate.save(user);
    }
    public void delete(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("userId").is(id)), User.class);
    }
    public List<User> getUser(String id) {
        return mongoTemplate.find(Query.query(Criteria.where("userId").is(id)), User.class);
    }
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }
    public void updateUser(String id, User user) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(id));
        Update update = new Update();
        String name = user.getUserName();
        String email = user.getEmail();
        if(name != null) {
            update.set("userName",name);
        }
        if(email != null) {
            update.set("email", email);
        }
        mongoTemplate.findAndModify(query, update, User.class );
    }
}
