package com.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoReview;
import com.spring.model.ModelCafeReview;


@Repository("servicereview")
public class ServiceReview implements IServiceReview {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceReview.class);
    
    @Autowired
    IDaoReview dao;
    
    @Override
    public int insertReview(ModelCafeReview review) {
        int result = -1;
        try {
            result = dao.insertReview(review);
        } catch (Exception e) {
            logger.error("insertReview" + e.getMessage() );
            throw e;
        }
        return result;
        
    }
}
