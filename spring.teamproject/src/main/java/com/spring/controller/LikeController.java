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

import com.spring.model.ModelCafeLike;
import com.spring.model.ModelCafeReview;
import com.spring.model.ModelUser;
import com.spring.service.IServiceCafeLike;
import com.spring.service.IServiceReview;
import com.spring.service.IServiceUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LikeController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(LikeController.class);
    
    @Autowired
    IServiceCafeLike  svr;
    
    @RequestMapping(value = "/like/insertBookmark", method = {RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int insertBookmark(Locale locale, Model model, @RequestBody ModelCafeLike like) {
        logger.info("/like/insertBookmark");
        
        int result = svr.insertBookmark(like);
        svr.increaseLike(like.getCafeno());
        
        return result;
    }
 
    @RequestMapping(value = "/like/getBookmark", method = {RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int getBookmark(Locale locale, Model model, @RequestParam(value="cafeno", defaultValue="")String cafeno,
                                                       @RequestParam(value="userno", defaultValue="")String userno) {
        logger.info("/like/insertBookmark");
        
        int result = svr.getBookmark(Integer.valueOf(cafeno), Integer.valueOf(userno));
        
        return result;
    }
    
    @RequestMapping(value = "/like/deleteBookmark", method = {RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int deleteBookmark(Locale locale, Model model, @RequestBody ModelCafeLike like) {
        logger.info("/like/deleteBookmark");
        
        int result = svr.deleteBookmark(like);
        svr.increaseLike(like.getCafeno());
        
        return result;
    }
   
    
}
