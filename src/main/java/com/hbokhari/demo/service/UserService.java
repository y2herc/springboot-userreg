package com.hbokhari.demo.service;



import com.hbokhari.demo.model.User;


public interface UserService {
    void create(User user);
    boolean userExists(String UserName);
}
