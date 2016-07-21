/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.controller;

import edu.adj.tf.service.UserService;
import java.io.File;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Asanka
 */
@Controller
@RequestMapping("/")
public class EditProfile {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "loadEditProfile" , method = RequestMethod.GET)
    public String loadEditProfile(HttpServletRequest request){
        return "editProfile";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request) {
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if (multipartContent) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = request.getServletContext();
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            try {
                List<FileItem> multiparts = servletFileUpload.parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String username = (String) request.getSession().getAttribute("username");
                        File file = new File(servletContext.getRealPath("/") + "/WEB-INF/RES/files/" + username + "/profile/profile.jpg");
                        item.write(file);

                        System.out.println(file.getAbsolutePath());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Not multipart");
        }
        return "editProfile";
    }
}
