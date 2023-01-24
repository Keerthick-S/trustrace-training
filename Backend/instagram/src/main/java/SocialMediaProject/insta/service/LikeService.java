package SocialMediaProject.insta.service;

import SocialMediaProject.insta.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    ServiceValidator serviceValidator;
    public void postLike(String postId, String instaId) throws Exception{
        serviceValidator.checkPostId(postId);
        likeRepository.postLike(postId, instaId);
    }
    public void postUnlike(String postId, String instaId) throws Exception {
        serviceValidator.checkPostId(postId);
        likeRepository.postUnlike(postId, instaId);
    }
}
