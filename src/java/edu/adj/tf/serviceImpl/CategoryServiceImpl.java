/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.serviceImpl;

import edu.adj.tf.dao.CategoryDao;
import edu.adj.tf.dto.Category;
import edu.adj.tf.service.CategoryService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asanka
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    public ArrayList<Category> getCategory() {
        return categoryDao.getCategory();
    }

    public Category searchCategoryById(String name) {
        return categoryDao.searchCategoryById(name);
    }
    

    
}
