/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.controller;

import edu.adj.tf.dto.User;
import edu.adj.tf.service.UserService;
import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Asanka
 */
@Controller
@RequestMapping("/")
public class SignUpController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "SignUp",method = RequestMethod.GET)
    public String signUp(ModelMap modelMap){
        modelMap.addAttribute("user", new User());
        return "signUp";
    }
    
    @RequestMapping(value = "addSignUp",method = RequestMethod.POST)
    public String addSignUp(ModelMap modelMap,User user,HttpServletRequest request){
        userService.addUser(user);
        HttpSession httpSession = request.getSession();
        ServletContext servletContext = request.getServletContext();
        
        File file = new File(servletContext.getRealPath("/")+"/WEB-INF/RES/files/"+user.getEmail());
        file.mkdir();
        file = new File(servletContext.getRealPath("/")+"/WEB-INF/RES/files/"+user.getEmail()+"/profile");
        file.mkdir();
        File file1 = new File(servletContext.getRealPath("/") + "/WEB-INF/RES/image/profile.jpg");
        file1 = new File(servletContext.getRealPath("/") + "/WEB-INF/RES/files/" +user.getEmail()+"/profile/profile.jpg");
        
        
        httpSession.setAttribute("username", user.getEmail());
        httpSession.setAttribute("path", "files/"+ httpSession.getAttribute("username")+"/profile/profile.jpg");
        return "editProfile";
    }
}
