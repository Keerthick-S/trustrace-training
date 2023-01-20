package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.User;
import SocialMediaProject.insta.repository.InstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    InstaRepository instaRepository;
    @Autowired
    ServiceValidator serviceValidator;
    public void signup(User user) throws Exception{
        serviceValidator.createCheckInstaId(user.getInstaId());
        instaRepository.signup(user);
    }
    public User getUserByInstaId(String instaId) throws Exception{
        serviceValidator.checkInstaId(instaId);
        return instaRepository.getUserByInstaId(instaId);
    }
    public void updateByInstaId(String instaId, User user) {
        instaRepository.updateByInstaId(instaId, user);
    }
    public void deleteUserByInstaId(String instaId) throws Exception {
        serviceValidator.checkInstaId(instaId);
        instaRepository.deleteUserByInstaId(instaId);
    }
    public List<User> getAllUser() {
        return instaRepository.getAllUser();
    }
    public void updateNoOfPostCount(String instaId, int count) {
        User user = instaRepository.getUserByInstaId(instaId);
        instaRepository.updateNoOfPost(instaId, count);
    }
    public void updateFollowing(String instaId, String followerInstaId) throws Exception {
        serviceValidator.checkInstaId(followerInstaId);
        User user = instaRepository.getUserByInstaId(instaId);
        User userToFollow = instaRepository.getUserByInstaId(followerInstaId);
        instaRepository.updateFollowing(instaId, followerInstaId, user.getFollowingList());
        instaRepository.updateFollower(followerInstaId, instaId, userToFollow.getFollowersList());
    }

}
