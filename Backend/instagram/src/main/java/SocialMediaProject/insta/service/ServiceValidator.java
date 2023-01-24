package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.Post;
import SocialMediaProject.insta.repository.UserRepository;
import SocialMediaProject.insta.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceValidator {
    @Autowired

    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    public void createCheckInstaId(String instaID) throws Exception {
        if(checkId(instaID) == true) {
            throw new Exception("This " + instaID + " Id is Already Exist");
        }
    }
    public boolean checkId(String userId) {
        return (userRepository.getUserByInstaId(userId) != null);
    }

    public void checkInstaId(String instaId) throws Exception {
        if(checkId(instaId) == false) {
            throw new Exception("This " + instaId + " Id is Not Exist");
        }
    }
    public void checkPostId(String postId) throws Exception {
        if(checkPostIdBoolean(postId) == true) {
            throw new Exception("This post is not Exist");
        }
    }
    public boolean checkPostIdBoolean(String postId) {
        return (postRepository.getPost(postId) == null);
    }
}
