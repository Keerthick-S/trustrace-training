package SocialMediaProject.insta.controller;

import SocialMediaProject.insta.pojo.User;
import SocialMediaProject.insta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public String signup(@RequestBody User user) throws Exception {
        userService.signup(user);
        return "Account Created Successfully";
    }
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    @GetMapping("/{instaId}")
    public User getUserByInstaId(@PathVariable String instaId) throws Exception {
        return userService.getUserByInstaId(instaId);
    }
    @DeleteMapping("/{instaId}")
    public String deleteByInstaId(@PathVariable String instaId) throws Exception {
        userService.deleteUserByInstaId(instaId);
        return "Deleted Successfully";
    }
    @PutMapping("/{instaId}")
    public void updateByInstaId(@PathVariable String instaId, @RequestBody User user) {
        userService.updateByInstaId(instaId, user);
    }
}
