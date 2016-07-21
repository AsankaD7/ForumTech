/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.serviceImpl;

import edu.adj.tf.dao.CategoryDetailDao;
import edu.adj.tf.dto.Category;
import edu.adj.tf.dto.Categorydetail;
import edu.adj.tf.service.CategoryDetailService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asanka
 */
@Service
public class CategoryDetailServiceImpl implements CategoryDetailService{
    
    @Autowired
    private CategoryDetailDao categoryDetailDao;

    public boolean addCategoryDetail(Categorydetail categorydetail) {
        return categoryDetailDao.addCategoryDetail(categorydetail);
    }

    public ArrayList<Category> getAllCategoryDetail() {
        return categoryDetailDao.getAllCategoryDetail();
    }
    
}
