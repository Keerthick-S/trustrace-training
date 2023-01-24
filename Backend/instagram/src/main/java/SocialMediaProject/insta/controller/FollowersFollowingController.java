package SocialMediaProject.insta.controller;

import SocialMediaProject.insta.pojo.Followers;
import SocialMediaProject.insta.pojo.Following;
import SocialMediaProject.insta.service.FollowersFollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FollowersFollowingController {
    @Autowired
    FollowersFollowingService followersFollowingService;
    @PutMapping("/{instaId}/follow/{followerInstaId}")
    public String updateFollowing(@PathVariable("instaId") String instaId,
                                  @PathVariable("followerInstaId") String followerInstaId) throws Exception {
        followersFollowingService.updateFollowingFollower(instaId, followerInstaId);
        return "started following";
    }
    @GetMapping("/{instaId}/following")
    public List<String> getFollowingByInstaId(@PathVariable("instaId") String instaId) throws Exception{
        return followersFollowingService.getFollowingByInstaId(instaId);
    }
    @GetMapping("/{instaId}/followers")
    public List<String> getFollowersByInstaId(@PathVariable String instaId) throws Exception {
        return followersFollowingService.getFollowersByInstaId(instaId);
    }
}
