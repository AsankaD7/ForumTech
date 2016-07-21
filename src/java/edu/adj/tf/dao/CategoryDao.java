/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.dao;

import edu.adj.tf.dto.Category;
import java.util.ArrayList;

/**
 *
 * @author Asanka
 */
public interface CategoryDao {
    public ArrayList<Category> getCategory();
    public Category searchCategoryById(String name);
}
