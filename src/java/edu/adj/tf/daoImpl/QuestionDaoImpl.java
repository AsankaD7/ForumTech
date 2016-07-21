/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.daoImpl;

import edu.adj.tf.dao.QuestionDao;
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
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public boolean addQuestion(Question question) {
        Session session = getSession();
        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public ArrayList<Question> gatAllQuestion() {
        Session session = getSession();
        Query namedQuery = session.getNamedQuery("Question.findAll");
        ArrayList<Question> questions = (ArrayList<Question>) namedQuery.list();
        if (questions == null) {
            questions = new ArrayList<Question>();
        }
        return questions;
    }

}
