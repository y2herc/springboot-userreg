package com.hbokhari.demo.model;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
 @PersistenceContext
 private EntityManager entityManager;

 
 public void create(User user) {
 entityManager.persist(user);
 }

 
 public void update(User user) {
 entityManager.merge(user);
 }

 
 public boolean userExists(String UserName) {
	 User user=new User();
	 try{
	  user= entityManager.createQuery(
		  "SELECT u from User u WHERE u.name = :name", User.class).
		  setParameter("name", UserName).getSingleResult();
	 }
	 catch (NoResultException e){
		 return false;
	 }
	 
	if(user.getName().equals(UserName))
	 return true;
	else
	return false;
 }


}