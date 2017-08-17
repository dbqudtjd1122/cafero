package com.spring.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spring.model.ModelCafeMenu;
import com.spring.model.ModelCafeinfo;
import com.spring.model.ModelUser;
import com.spring.service.IServiceCafeMenu;
import com.spring.service.IServiceCafeinfo;

public class CafenoMenu {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(CafenoMenu.class);
    
    @Autowired
    IServiceCafeMenu      svr;
    
    @RequestMapping(value = "/menu/cafenomenu", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelCafeMenu> getCafeMenu(Locale locale, Model model,
            @RequestBody ModelCafeMenu cafeno) {
        logger.info("/menu/cafenomenu");
        ModelCafeMenu menu = new ModelCafeMenu();
        menu.getCafeno();
        
        List<ModelCafeMenu> result = svr.getCafeMenu(1);
        
        return result;
    }
}