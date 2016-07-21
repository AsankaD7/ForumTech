/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.service;

import edu.adj.tf.dto.Category;
import edu.adj.tf.dto.Categorydetail;
import java.util.ArrayList;

/**
 *
 * @author Asanka
 */
public interface CategoryDetailService {

    public boolean addCategoryDetail(Categorydetail categorydetail);

    public ArrayList<Category> getAllCategoryDetail();
}
