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

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IServiceUser svr;
	
	@RequestMapping(value = "/team/currentversion", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public long currentversion(Locale locale, Model model) {
		logger.info("/team/currentversion");
		
		
		return new Date().getTime();
	}
	
	@RequestMapping(value = "/team/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int currentversion(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email
                                                        , @RequestParam(value="passwd", defaultValue="")String passwd) {
        logger.info("/team/login");
        ModelUser team= new ModelUser(email, passwd);
        
        int result = svr.login(team);
        
        return result;
    }
	
	@RequestMapping(value = "/team/teamone", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelUser teamone(Locale locale, Model model, @RequestParam(value="name", defaultValue="")String name) {
        logger.info("/team/teamone");
        
        ModelUser result = new ModelUser("email", "pw", "userphone", "useraddr", "y", "n", "상어알");
        
        return result;
    }
	
	@RequestMapping(value = "/team/Teamlist", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ModelUser> Teamlist(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email) {
        logger.info("/team/Teamlist");
        ModelUser team= new ModelUser();
        team.setEmail(email);
        
        List<ModelUser> result = svr.getTeamList(team);
        
        return result;
    }
	
	/*@RequestMapping(value = "/user/changepassword", method = RequestMethod.POST)
    public String changepassword(Model model
            , RedirectAttributes rttr
            , @RequestParam(value="currentPasswd", defaultValue="") String  currentPasswd
            , @RequestParam(value="newPasswd", defaultValue=""    ) String  newPasswd
            , HttpSession session ) {
        logger.info("changepassword : post");
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        int result = svr.updatePasswd(newPasswd, currentPasswd, user.getEmail() );
        
        if( result == 1) {
            return "user/changepassword_post";
        }
        else {
            rttr.addFlashAttribute("msg", "DB 오류로 인해 패스워드 변경 실패. 관리자 문의");                 
            return "redirect:/user/changepassword";
        }
    }*/
	
}
