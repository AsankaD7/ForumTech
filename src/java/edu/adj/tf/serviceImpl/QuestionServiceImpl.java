/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.serviceImpl;

import edu.adj.tf.dao.QuestionDao;
import edu.adj.tf.dto.Question;
import edu.adj.tf.service.QuestionService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asanka
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionDao questionDao;

    public boolean addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }

    public ArrayList<Question> getAllQuestion() {
        return questionDao.gatAllQuestion();
    }
    
    
}
