package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.User;
import SocialMediaProject.insta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ServiceValidator serviceValidator;
    public void signup(User user) throws Exception{
        serviceValidator.createCheckInstaId(user.getInstaId());
        userRepository.signup(user);
    }
    public User getUserByInstaId(String instaId) throws Exception{
        serviceValidator.checkInstaId(instaId);
        return userRepository.getUserByInstaId(instaId);
    }
    public void updateByInstaId(String instaId, User user) {
        userRepository.updateByInstaId(instaId, user);
    }
    public void deleteUserByInstaId(String instaId) throws Exception {
        serviceValidator.checkInstaId(instaId);
        userRepository.deleteUserByInstaId(instaId);
    }
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
    public void updateNoOfPostCount(String instaId, int count) {
        User user = userRepository.getUserByInstaId(instaId);
        userRepository.updateNoOfPost(instaId, count);
    }
}
