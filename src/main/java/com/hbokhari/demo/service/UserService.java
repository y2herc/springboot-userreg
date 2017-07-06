package com.hbokhari.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hbokhari.demo.model.User;
import com.hbokhari.demo.model.UserDao;

@Transactional
public class UserService {

@Autowired
 private UserDao userDao;

 public void create(User user) {
 userDao.create(user);
 }
}