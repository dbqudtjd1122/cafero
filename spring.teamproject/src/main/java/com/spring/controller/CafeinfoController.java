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
	
	private static Logger logger = LoggerFactory.getLogger(CafeinfoController.class);
	
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
	
	@RequestMapping(value = "/team/getCafeListName", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ModelCafeinfo> getCafeListName( Model model, @RequestParam(value="cafename", defaultValue="")String name) {
        logger.info("/team/getCafeListName");
         
        
        List<ModelCafeinfo> result = svr.getCafeListName(name);
                
        return result;
    }
	
	@RequestMapping(value = "/team/getCafeListAddr", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ModelCafeinfo> getCafeListAddr( Model model, @RequestParam(value="cafeaddr", defaultValue="")String addr) {
        logger.info("/team/getCafeListAddr");
         
        
        List<ModelCafeinfo> result = svr.getCafeListAddr(addr);
                
        return result;
    }
	
	@RequestMapping(value = "/team/getCafeOne", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelCafeinfo getCafeOne( Model model, @RequestParam(value="cafeno", defaultValue="")String cafeno) {
        logger.info("/team/getCafeListAddr");
         
        ModelCafeinfo cafeinfo = new ModelCafeinfo();
        cafeinfo.setCafeno(Integer.parseInt(cafeno));
        ModelCafeinfo result = svr.getCafeOne(cafeinfo);    
                
        return result;
    }
}
