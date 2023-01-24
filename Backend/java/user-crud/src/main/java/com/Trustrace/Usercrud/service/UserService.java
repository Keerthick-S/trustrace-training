package com.Trustrace.Usercrud.service;

import com.Trustrace.Usercrud.repository.UserRepository;
import com.Trustrace.Usercrud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void create(User user) {
        userRepository.create(user);
    }
    public void delete(String id) {
        userRepository.delete(id);
    }
    public List<User> getAllUsers(String page, String limit) {
        return userRepository.getAllUsers(Integer.parseInt(page), Integer.parseInt(limit));
    }
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public List<User> getUser(String id) {
        return userRepository.getUser(id);
    }
    public void updateUser(String id, User user) {
        userRepository.updateUser(id, user);
    }
}
