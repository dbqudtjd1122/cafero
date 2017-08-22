package com.spring.service;

import java.util.List;

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
    public List<ModelCafeReview> getReviewList(String cafeno) {
        List<ModelCafeReview> result;
        try {
            result = dao.getReviewList(cafeno);
        } catch (Exception e) {
            logger.error("getReviewList" + e.getMessage() );
            throw e;
        }
        return result;
    }


}
