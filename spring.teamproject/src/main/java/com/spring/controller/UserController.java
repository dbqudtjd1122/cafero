package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.model.ModelUser;
import com.spring.service.IServiceUser;

import android.service.textservice.SpellCheckerService.Session;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IServiceUser svr;
	
	
	@RequestMapping(value = "/team/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelUser Login(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email
                                                        , @RequestParam(value="passwd", defaultValue="")String passwd) {
        logger.info("/team/login");
        ModelUser team= new ModelUser(email, passwd);
        ModelUser result = new ModelUser();
        result = svr.login(team);
    
        return result;
    }
	
	@RequestMapping(value = "/team/insertuser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int insertUser(Locale locale, Model model, @RequestBody ModelUser user) {
        logger.info("/team/insertuser");
        
        int result = svr.insertUser(user);
        
        return result;
    }
	
	@RequestMapping(value = "/user/updateUserInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public int updateUserinfo(Locale locale, Model model
                            ,@RequestParam(value="email", defaultValue="")String email
                            ,@RequestParam(value="passwd", defaultValue="")String passwd
                            ,@RequestParam(value="userphone", defaultValue="")String userphone
                            ,@RequestParam(value="addr", defaultValue="")String useraddr
                            ,@RequestParam(value="sex", defaultValue="")String sex
                            ,@RequestParam(value="nickname", defaultValue="")String usernickname
                            ,@RequestParam(value="selectEmail", defaultValue="")Integer emailselect) {
        logger.info("updateUserInfo : post");
 
        ModelUser updateValue = new ModelUser();
        updateValue.setPasswd(passwd);
        updateValue.setUserphone(userphone);
        updateValue.setUseraddr(useraddr);
        updateValue.setSex(sex);
        updateValue.setUsernickname(usernickname);
        updateValue.setEmailselect(emailselect);
        ModelUser searchValue = new ModelUser(email);
        
        int result = svr.updateUserinfo(updateValue, searchValue);
                         
        return result;     
       
    }
	
	@RequestMapping(value = "/user/updatePasswd", method = {RequestMethod.GET, RequestMethod.POST})
    public int updatePasswd(Locale locale, Model model
                            ,@RequestParam(value="email", defaultValue="")String email
                            ,@RequestParam(value="passwd", defaultValue="")String passwd
                            ,@RequestParam(value="newPasswd", defaultValue="")String newPasswd) {
        logger.info("updateUserInfo : post");
        
        int result = svr.updatePasswd(email, passwd, newPasswd);
                         
        return result;     
       
    }
	
	   @RequestMapping(value = "/user/deleteUser", method = {RequestMethod.GET, RequestMethod.POST})
       @ResponseBody
       public int deleteuser(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email) {
           logger.info("/team/login");
           
           ModelUser user = new ModelUser(email);
           
           int result = svr.deleteUser(user);
           
           return result;
       }
	   
	   @RequestMapping(value = "/team/selectid", method = {RequestMethod.GET, RequestMethod.POST})
       @ResponseBody
       public ModelUser selectId(Locale locale, Model model, @RequestParam(value="userphone", defaultValue="")String userphone) {
           logger.info("/team/selectid");
           ModelUser team= new ModelUser();
           team.setUserphone(userphone);
          
           ModelUser result = svr.selectId(team);
           
           return result;
       }
       
       @RequestMapping(value = "/team/selectpwd", method = {RequestMethod.GET, RequestMethod.POST})
       @ResponseBody
       public ModelUser selectPwd(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email) {
           logger.info("/team/selectpwd");
           ModelUser team= new ModelUser();
           team.setEmail(email);
           
           ModelUser result = svr.selectPwd(team);
           
           return result;
       }
	
}
