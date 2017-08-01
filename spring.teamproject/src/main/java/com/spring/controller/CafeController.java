package com.spring.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.ModelCafe;
import com.spring.model.ModelTeam;
import com.spring.service.IServiceCafe;
import com.spring.service.IServiceTeam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CafeController {
	
	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);
	
	@Autowired
	IServiceCafe svr;
	
	@RequestMapping(value = "/team/getcafelist", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ModelCafe> getCafeList(Locale locale, Model model) {
        logger.info("/team/getcafelist");
        
        List<ModelCafe> result = svr.getCafeList();
        
        return result;
    }
}
