package com.hbokhari.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbokhari.demo.model.User;
import com.hbokhari.demo.model.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(User user) {
        userDao.create(user);
    }

	@Override
	public boolean userExists(String UserName) {
		
		if(userDao.userExists(UserName))
			return true;
		else
		return false;
	}
    
    
}
