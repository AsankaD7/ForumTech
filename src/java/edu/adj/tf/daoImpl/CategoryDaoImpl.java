/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.daoImpl;

import edu.adj.tf.dao.CategoryDao;
import edu.adj.tf.dto.Category;
import java.util.ArrayList;
import java.util.List;
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
public class CategoryDaoImpl implements CategoryDao{
    
    @Autowired
    private SessionFactory sessionsFactory;
    public Session getSession(){
        return sessionsFactory.openSession();
    }

    public ArrayList<Category> getCategory() {
        Session session = getSession();
        Query namedQuery = session.getNamedQuery("Category.findAll");
        ArrayList<Category> categorys = (ArrayList<Category>) namedQuery.list();
        if (categorys == null) {
            categorys = new ArrayList<Category>();
        }
        return categorys;        
    }

    public Category searchCategoryById(String name) {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Category.findByName");
        query.setString("name", name);
        List<Category> categorys = query.list();
        if (categorys.size() > 0) {
            return categorys.get(0);
        }
        return null;
    }
    

    
}
