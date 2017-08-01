package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import com.spring.model.ModelTeam;
import com.spring.service.IServiceTeam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	IServiceTeam svr;
	
	@RequestMapping(value = "/team/currentversion", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public long currentversion(Locale locale, Model model) {
		logger.info("/team/currentversion");
		
		
		return new Date().getTime();
	}
	
	@RequestMapping(value = "/team/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int currentversion(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email
                                                        , @RequestParam(value="pw", defaultValue="")String pw) {
        logger.info("/team/login");
        ModelTeam team= new ModelTeam(email, pw);
        
        int result = svr.login(team);
        
        return result;
    }
	
	@RequestMapping(value = "/team/teamone", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelTeam teamone(Locale locale, Model model, @RequestParam(value="name", defaultValue="")String name) {
        logger.info("/team/teamone");
        
        ModelTeam result = new ModelTeam("email", "pw", "phone", "address", "y", "n");
        
        return result;
    }
	
	@RequestMapping(value = "/team/Teamlist", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ModelTeam> Teamlist(Locale locale, Model model, @RequestParam(value="email", defaultValue="")String email) {
        logger.info("/team/Teamlist");
        ModelTeam team= new ModelTeam();
        team.setEmail(email);
        
        List<ModelTeam> result = svr.getTeamList(team);
        
        return result;
    }
	
	@RequestMapping(value = "/team/insertteam", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int insertTeam(Locale locale, Model model, @RequestBody ModelTeam team) {
	    logger.info("/team/insertteam");
        
        int result = svr.insertTeam(team);
        
        return result;
    }
	
}
