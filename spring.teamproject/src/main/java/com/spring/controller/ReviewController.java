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

import com.spring.model.ModelCafeReview;
import com.spring.model.ModelUser;
import com.spring.service.IServiceReview;
import com.spring.service.IServiceUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReviewController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(ReviewController.class);
    
    @Autowired
    IServiceReview              svr;
    
    // @RequestParam(value="grade", defaultValue="") String grade)
    
    @RequestMapping(value = "/review/insertReview", method = {RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int insertReview(Locale locale, Model model, @RequestBody ModelCafeReview reivew) {
        logger.info("/review/insertReview");
        
        int result = svr.insertReview(reivew);
        
        return result;
    }
    
}
