package SocialMediaProject.insta.controller;

import SocialMediaProject.insta.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    LikeService likeService;
    @PutMapping("/{instaId}/{postId}")
    public void postLike(@PathVariable("instaId") String instaId, @PathVariable("postId") String postId) throws Exception{
        likeService.postLike(postId, instaId);
    }
    @PutMapping("/unlike/{instaId}/{postId}")
    public void postUnlike(@PathVariable("instaId") String instaId, @PathVariable("postId") String postId) throws Exception {
        likeService.postUnlike(postId, instaId);
    }
}
