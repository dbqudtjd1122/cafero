package com.spring.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import com.google.gson.Gson;
import com.spring.model.ModelCafeinfo;
import com.spring.model.ModelUser;
import com.spring.service.IServiceCafeinfo;
import com.spring.service.IServiceUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CafeinfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(CafeinfoController.class);
	
	@Autowired
	IServiceCafeinfo svr;
	
	@RequestMapping(value = "/team/getcafelist", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ModelCafeinfo> getCafeList( Model model
            , @RequestBody Map<String, Object> map) {
        logger.info("/team/getcafelist");
        ModelCafeinfo cafebigtype = new Gson().fromJson( map.get("cafebigtype").toString(), ModelCafeinfo.class);
        String orderKind = (String) map.get("orderKind");
        
        
        List<ModelCafeinfo> result = svr.getCafeList(cafebigtype, orderKind);
        
        return result;
    }
	
	
	
}
