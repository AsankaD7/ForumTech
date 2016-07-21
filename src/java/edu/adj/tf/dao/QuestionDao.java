/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.dao;

import edu.adj.tf.dto.Question;
import java.util.ArrayList;

/**
 *
 * @author Asanka
 */
public interface QuestionDao {
    public boolean addQuestion(Question question);
    public ArrayList<Question> gatAllQuestion();
}
