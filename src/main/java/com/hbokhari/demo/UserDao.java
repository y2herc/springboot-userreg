package com.hbokhari.demo;

import javax.persistence.EntityManager;
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

 
 public User getUserById(long id) {
 return entityManager.find(User.class, id);
 }

 
 public void delete(long id) {
 User user = getUserById(id);
 if (user != null) {
 entityManager.remove(user);
 }
 }
}