package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.Followers;
import SocialMediaProject.insta.pojo.Following;
import SocialMediaProject.insta.repository.FollowersFollowingRepository;
import SocialMediaProject.insta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowersFollowingService {
    @Autowired
    FollowersFollowingRepository followersFollowingRepository;
    @Autowired
    ServiceValidator serviceValidator;
    @Autowired
    UserRepository userRepository;
    public void updateFollowingFollower(String instaId, String toFollowInstaId) throws Exception {
       followersFollowingRepository.updateFollowing(instaId, toFollowInstaId);
       serviceValidator.checkInstaId(toFollowInstaId);
       updateFollowersFollowingCount(instaId, toFollowInstaId);
       followersFollowingRepository.updateFollowers(toFollowInstaId, instaId);
    }
    public List<String> getFollowingByInstaId(String instaId) throws Exception{
        serviceValidator.checkInstaId(instaId);
        return followersFollowingRepository.getFollowingByInstaId(instaId);
    }
    public List<String> getFollowersByInstaId(String instaId) throws Exception {
        serviceValidator.checkInstaId(instaId);
        return followersFollowingRepository.getFollowersByInstaId(instaId);
    }
    public void updateFollowersFollowingCount(String instaId, String toFollowId) {
        userRepository.updateFollowingCount(instaId);
        userRepository.updateFollowersCount(toFollowId);
    }
}
