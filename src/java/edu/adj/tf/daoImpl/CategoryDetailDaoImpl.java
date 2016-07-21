/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.daoImpl;

import edu.adj.tf.dao.CategoryDetailDao;
import edu.adj.tf.dto.Category;
import edu.adj.tf.dto.Categorydetail;
import edu.adj.tf.dto.Question;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Asanka
 */
@Repository
public class CategoryDetailDaoImpl implements CategoryDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public boolean addCategoryDetail(Categorydetail categorydetail) {
        Session session = getSession();
        session.beginTransaction();
        session.save(categorydetail);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public ArrayList<Category> getAllCategoryDetail() {
        Session session = getSession();
        Query namedQuery = session.getNamedQuery("Categorydetail.findAll");
        ArrayList<Category> categorys = (ArrayList<Category>) namedQuery.list();
        if (categorys == null) {
            categorys = new ArrayList<Category>();
        }
        return categorys;    
    }
    

}
