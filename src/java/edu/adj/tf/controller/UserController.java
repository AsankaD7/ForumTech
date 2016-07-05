/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.controller;

import static edu.adj.tf.dto.Questionvote_.user;
import edu.adj.tf.dto.User;
import edu.adj.tf.service.UserService;
import javax.servlet.http.HttpServletRequest;
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
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "User",method = RequestMethod.GET)
    public String loadUser(ModelMap modelMap,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        User user1 = new User();
        modelMap.addAttribute("user", user1);
        return "User";
    }
    
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(@Valid User user1,ModelMap modelMap){
        userService.addUser(user1);
        modelMap.addAttribute("user", new User());
        return "User";
    }
}
