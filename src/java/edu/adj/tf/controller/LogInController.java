/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.controller;

import edu.adj.tf.dto.User;
import edu.adj.tf.service.UserService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
public class LogInController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "LogIn",method = RequestMethod.GET)
    public String logIn(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        modelMap.addAttribute("user", new User());
        session.setAttribute("path", "image/profile.jpg");
        return "logIn";
    }
    
    @RequestMapping(value = "addLogIn",method = RequestMethod.POST)
    public String addUser(User user,ModelMap modelMap,HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        HttpSession httpSession = request.getSession();
        User login = userService.login(user);
        
        if(null != login){
           httpSession.setAttribute("username", login.getEmail());
           httpSession.setAttribute("user",login);
           httpSession.setAttribute("path", "files/" + httpSession.getAttribute("username") + "/profile/profile.jpg");
           if(user.getPassword().equals(login.getPassword())){
               return "questionWall";
           }else{
               return "logIn";
           }
        }else{
            httpSession.setAttribute("path", "image/profile.jpg");
            return "logIn";            
        }
    }
}
