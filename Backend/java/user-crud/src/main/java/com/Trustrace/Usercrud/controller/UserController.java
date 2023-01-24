package com.Trustrace.Usercrud.controller;

import com.Trustrace.Usercrud.service.UserService;
import com.Trustrace.Usercrud.pojo.User;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //    private Logger logger = LoggerFactory.getLogger(UserCrudApplication.class);
    @PostMapping()
    public String create(@RequestBody User user) {
        userService.create(user);
        return "Created Successfully";
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable String id) {
        userService.delete(id);
        return "Deleted Successfully";
    }
    @GetMapping()
    public List<User> getAllUsers(@RequestParam (value = "page", defaultValue = "1") String page,
                                  @RequestParam (value = "limit", defaultValue = "10") String limit) {
        return userService.getAllUsers(page, limit);
    }
    @GetMapping("/multiple")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User user) {
        userService.updateUser(id , user);
        return "Updated Successfully";
    }
    @GetMapping("/{id}")
    public List<User> getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
}
