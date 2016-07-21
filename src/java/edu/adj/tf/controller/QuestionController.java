/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.controller;

import edu.adj.tf.dto.Category;
import edu.adj.tf.dto.Categorydetail;
import edu.adj.tf.dto.Question;
import edu.adj.tf.dto.User;
import edu.adj.tf.service.CategoryDetailService;
import edu.adj.tf.service.CategoryService;
import edu.adj.tf.service.QuestionService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Asanka
 */
@Controller
@RequestMapping("/")
public class question {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CategoryDetailService categoryDetailService;

    @RequestMapping(value = "askQuestion", method = RequestMethod.GET)
    public String askQuestion(HttpServletRequest request, Model model) {
        ArrayList<Category> category = categoryService.getCategory();
        model.addAttribute("category", category);
        return "askQuestion";
    }

    @RequestMapping(value = "questionWall", method = RequestMethod.GET)
    public String questionWall(HttpServletRequest request) {
        return "questionWall";
    }

    @RequestMapping(value = "saveQuestion", method = RequestMethod.POST)
    public void saveQuestion(HttpServletRequest request, HttpServletResponse response) {
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(question.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String text = request.getParameter("body");
        String cat = request.getParameter("category");
        String head = request.getParameter("head");

//        ServletContext servletContext = request.getServletContext();
//        File file = new File(servletContext.getRealPath("/") + "/WEB-INF/RES/ques/A.xml");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
        String data
                = "<div class='question-head'>"
                + head + "\n"
                + "</div>\n"
                + "<br/>\n" + "<div class=''>\n"
                + cat + "\n"
                + "</div>\n"
                + "<div class='question-body'>\n"
                + text + "\n"
                + "</div>\n";

        String qId = "01";
        User user = (User) request.getSession().getAttribute("user");

        Question question = new Question();
        question.setQId(qId);
        question.setUserId(user);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = simpleDateFormat.format(date);
        question.setDate(formatDate);
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String formatTime = simpleDateFormat.format(date);
        question.setTime(formatTime);
        question.setQuestion(data);
        

        String[] categories = cat.split("[,]");
        List<Categorydetail> categorydetailList = new ArrayList<Categorydetail>();
        for (String category : categories) {
            Categorydetail categorydetail = new Categorydetail();
            categorydetail.setCId(categoryService.searchCategoryById(category));
            categorydetail.setQId(question);
            categorydetailList.add(categorydetail);
        }
        question.setCategorydetailList(categorydetailList);
        questionService.addQuestion(question);
        for (Categorydetail categorydetail : categorydetailList) {
            categoryDetailService.addCategoryDetail(categorydetail);
        }

        if (null != out) {
            out.print(data);
        }
    }
}
