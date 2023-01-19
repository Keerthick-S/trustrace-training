package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.Post;
import SocialMediaProject.insta.repository.InstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    InstaRepository instaRepository;
    @Autowired
    UserService userService;
    public void createPost(String instaId, Post post) {
        post.setInstaId(instaId);
        post.setTimeAndDate(LocalDateTime.now());
        instaRepository.createPost(post);
        countNoOfPost(instaId);
    }
    public List<Post> userAllPost(String instaId) {
        return instaRepository.userAllPost(instaId);
    }
    public List<Post> getAllPost() {
        return instaRepository.getAllPost();
    }
    public void deletePost(String instaId, String id) {
        instaRepository.deletePost(id);
        countNoOfPost(instaId);
    }
    public Post getPost(String id) {
        return instaRepository.getPost(id);
    }
    public void countNoOfPost(String instaId) {
        List<Post> userPost = instaRepository.userAllPost(instaId);
        userService.updateNoOfPostCount(instaId, userPost.size());
    }
}
