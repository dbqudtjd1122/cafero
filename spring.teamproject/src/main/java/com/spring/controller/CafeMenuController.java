package com.spring.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spring.model.ModelCafeMenu;
import com.spring.model.ModelUser;
import com.spring.service.IServiceCafeMenu;

@Controller
public class CafeMenuController {
    // SLF4J Logging
    private static final Logger logger = LoggerFactory.getLogger(CafeMenuController.class);
    
    @Autowired
    IServiceCafeMenu      svr;
    
    @RequestMapping(value = "/menu/getCafecd", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<String> getCafecd(Locale locale, Model model, @RequestParam String brand) {
        logger.info("/menu/getCafecd");
        
        List<String> menucd = svr.getCafecd(brand);
        
        return menucd;
    }
    
    @RequestMapping(value = "/menu/getCafeMenu", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<ModelCafeMenu> getCafeMenu(Locale locale, Model model, @RequestParam String menucd,
                                                                @RequestParam String brand) {
        logger.info("/menu/getCafeMenu");
        
        List<ModelCafeMenu> menulist = svr.getCafeMenu(menucd, brand);
        
        return menulist;
    }
}