package SocialMediaProject.insta.service;

import SocialMediaProject.insta.pojo.Post;
import SocialMediaProject.insta.repository.InstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceValidator {
    @Autowired
    InstaRepository instaRepository;
    public void createCheckInstaId(String instaID) throws Exception {
        if(checkId(instaID) == true) {
            throw new Exception("This " + instaID + " Id is Already Exist");
        }
    }
    public boolean checkId(String userId) {
        return (instaRepository.getUserByInstaId(userId) != null);
    }

    public void checkInstaId(String instaId) throws Exception {
        if(checkId(instaId) == false) {
            throw new Exception("This " + instaId + " Id is Not Exist");
        }
    }
    public void viewPreValidator(String id, String instaId, Post post) {
        if(post.getInstaId() != instaId) {
            instaRepository.updateView(id, post);
        }
    }
}
