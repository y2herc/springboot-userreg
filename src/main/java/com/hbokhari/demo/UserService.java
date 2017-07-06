package com.hbokhari.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class UserService {

@Autowired
 private UserDao userDao;

 public void create(User user) {
 userDao.create(user);
 }
}