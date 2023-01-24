package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.Post;
import SocialMediaProject.insta.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    @Autowired
    ServiceValidator serviceValidator;
    public void createPost(String instaId, Post post) {
        post.setInstaId(instaId);
        post.setTimeAndDate(LocalDateTime.now());
        post.setViews(0);
        postRepository.createPost(post);
        countNoOfPost(instaId);
    }
    public List<Post> userAllPost(String instaId) {
        return postRepository.userAllPost(instaId);
    }
    public List<Post> getAllPost() {
        return postRepository.getAllPost();
    }
    public void deletePost(String instaId, String id) {
        postRepository.deletePost(id);
        countNoOfPost(instaId);
    }
    public Post getPost(String id, String instaId) {
        Post post = postRepository.getPost(id);
        if(post.getInstaId() != instaId) {
            postRepository.updateView(id, post);
        }
        return post;
    }
    public void countNoOfPost(String instaId) {
        List<Post> userPost = postRepository.userAllPost(instaId);
        userService.updateNoOfPostCount(instaId, userPost.size());
    }
    public List<Post> getTopPost(int page, int limit) {
        return postRepository.getTopPost(page, limit);
    }
}
