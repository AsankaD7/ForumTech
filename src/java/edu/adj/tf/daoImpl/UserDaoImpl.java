/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.daoImpl;

import edu.adj.tf.dao.UserDao;
import edu.adj.tf.dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Asanka
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionsFactory;
    public Session getSession(){
        return sessionsFactory.openSession();
    }
    
    public void addUser(User user1) {
        Session session = getSession();
        session.beginTransaction();
        session.save(user1);
        session.getTransaction().commit();
        session.close();
    }
    
}
