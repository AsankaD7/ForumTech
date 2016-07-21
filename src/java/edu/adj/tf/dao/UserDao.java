/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.dao;

import edu.adj.tf.dto.User;

/**
 *
 * @author Asanka
 */
public interface UserDao {

    public void addUser(User user1);
    public User login(User user);
}
