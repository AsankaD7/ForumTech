/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.serviceImpl;

import edu.adj.tf.dao.UserDao;
import edu.adj.tf.dto.User;
import edu.adj.tf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asanka
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    public void addUser(User user1) {
        userDao.addUser(user1);
        
    }
    
}
